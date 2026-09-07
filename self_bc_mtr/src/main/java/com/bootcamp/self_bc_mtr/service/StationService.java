package com.bootcamp.self_bc_mtr.service;

import com.bootcamp.self_bc_mtr.repository.LineRepository;
import com.bootcamp.self_bc_mtr.repository.StationRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.self_bc_mtr.dto.LineSignalDto;
import com.bootcamp.self_bc_mtr.dto.MtrDto;
import com.bootcamp.self_bc_mtr.dto.RespondDto;
import com.bootcamp.self_bc_mtr.entity.LineEntity;
import com.bootcamp.self_bc_mtr.entity.StationEntity;

@Service
public class StationService {
  private final RestTemplate restTemplate;
  private final StationRepository stationRepository;
  private final LineRepository lineRepository;

  // Spring 注入 DB 同 RestTemplate
  public StationService(StationRepository stationRepository,
      RestTemplate restTemplate, LineRepository lineRepository) {
    this.stationRepository = stationRepository;
    this.restTemplate = restTemplate;
    this.lineRepository = lineRepository;
  }

  // 把一站寫入 DB
  public StationEntity save(StationEntity stationEntity) {
    return stationRepository.save(stationEntity);
  }

  // 用 stationCode 搵一站
  public Optional<StationEntity> getStation(String stationCode) {
    return stationRepository.findByStationCode(stationCode);
  }

  // 全部站
  public List<StationEntity> findallStation() {
    return stationRepository.findAll();
  }

  // 某條線全部站
  public List<StationEntity> findlineCode(String lineCode) {
    return stationRepository.findByLineCode(lineCode);
  }

  // 新站；改上一站 next、下一站 previous
  public StationEntity insertStation(StationEntity b) {
    String b_station_code = b.getStationCode();
    if (b_station_code == null || b_station_code.isBlank()) {
      throw new IllegalArgumentException("Incorrect StationCode");
    }
    if (getStation(b_station_code).isPresent()) {
      throw new IllegalArgumentException("code already exists");
    }
    b = save(b);

    String previous = b.getPrevious();
    if (previous != null && !previous.isBlank()) {
      Optional<StationEntity> prevOpt = getStation(previous);
      if (prevOpt.isPresent()) {
        StationEntity a = prevOpt.get();
        a.setNext(b_station_code);
        save(a);
      }
    }

    String next = b.getNext();
    if (next != null && !next.isBlank()) {
      Optional<StationEntity> nextOpt = getStation(next);
      if (nextOpt.isPresent()) {
        StationEntity c = nextOpt.get();
        c.setPrevious(b_station_code);
        save(c);
      }
    }
    return b;
  }

  // 刪站；左右鄰居互相接上
  public void removeStation(String stationCode) {
    Optional<StationEntity> opt = stationRepository.findByStationCode(stationCode);
    if (opt.isEmpty()) {
      throw new IllegalArgumentException("stationCode not exist");
    }
    StationEntity b = opt.get();
    String previous = b.getPrevious();
    String next = b.getNext();
    stationRepository.deleteById(b.getId());

    if (previous != null && !previous.isBlank()) {
      Optional<StationEntity> prevOpt = getStation(previous);
      if (prevOpt.isPresent()) {
        StationEntity a = prevOpt.get();
        a.setNext(next);
        save(a);
      }
    }
    if (next != null && !next.isBlank()) {
      Optional<StationEntity> nextOpt = getStation(next);
      if (nextOpt.isPresent()) {
        StationEntity c = nextOpt.get();
        c.setPrevious(previous);
        save(c);
      }
    }
  }

  // 練習用：寫死 TKL-TKO 拉原始 JSON
  public MtrDto getMtrDto() {
    String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=TKL&sta=TKO";
    return restTemplate.getForObject(url, MtrDto.class);
  }

  // 該站上／下行各自最早一班
  public RespondDto getEarliestArrival(String line, String sta) {
    String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=" + line + "&sta=" + sta;

    Optional<StationEntity> station = getStation(sta);
    if (station.isEmpty()) {
      throw new IllegalArgumentException("Station not in database");
    }

    StationEntity s = station.get();
    if (!s.getLineCode().equals(line)) {
      throw new IllegalArgumentException("This station does not belong to this line.");
    }

    MtrDto result = restTemplate.getForObject(url, MtrDto.class);
    if (result == null || result.getData() == null) {
      throw new IllegalArgumentException("invalid input");
    }

    MtrDto.MtrStopData stopData = result.getData().get(line + "-" + sta);
    List<RespondDto.Train> trains = new ArrayList<>();
    if (stopData == null) {
      throw new IllegalArgumentException("invalid line/station code");
    }

    if (stopData.UP != null && !stopData.UP.isEmpty()) {
      List<MtrDto.MtrArrival> upList = stopData.UP;
      MtrDto.MtrArrival earliest = upList.get(0);
      for (int i = 1; i < upList.size(); i++) {
        if (upList.get(i) != null
            && upList.get(i).time != null
            && earliest.time != null
            && upList.get(i).time.compareTo(earliest.time) < 0) {
          earliest = upList.get(i);
        }
      }
      trains.add(RespondDto.Train.builder()
          .destination(earliest.dest)
          .arrivalTime(earliest.time)
          .direction("UP")
          .build());
    }

    if (stopData.DOWN != null && !stopData.DOWN.isEmpty()) {
      List<MtrDto.MtrArrival> downList = stopData.DOWN;
      MtrDto.MtrArrival earliestDown = downList.get(0);
      for (int i = 1; i < downList.size(); i++) {
        if (downList.get(i) != null
            && downList.get(i).time != null
            && earliestDown.time != null
            && downList.get(i).time.compareTo(earliestDown.time) < 0) {
          earliestDown = downList.get(i);
        }
      }
      trains.add(RespondDto.Train.builder()
          .destination(earliestDown.dest)
          .arrivalTime(earliestDown.time)
          .direction("DOWN")
          .build());
    }

    return RespondDto.builder()
        .curr_time(result.getCurr_time())
        .sys_time(result.getSys_time())
        .currentStation(sta)
        .trains(trains)
        .build();
  }

  // 一條線：計 GREEN / YELLOW / RED
  public LineSignalDto getSignal(String line) {
    if (lineRepository.findById(line).isEmpty()) {
      throw new IllegalArgumentException("no such line code");
    }

    List<StationEntity> stations = stationRepository.findByLineCode(line);
    if (stations.isEmpty()) {
      throw new IllegalArgumentException("Empty input");
    }

    List<String> delayStations = new ArrayList<>();
    String currTime = null;
    String sysTime = null;

    for (StationEntity s : stations) {
      String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line="
          + line + "&sta=" + s.getStationCode();
      MtrDto mtr = restTemplate.getForObject(url, MtrDto.class);
      if (mtr != null) {
        currTime = mtr.getCurr_time();
        sysTime = mtr.getSys_time();
        if ("Y".equals(mtr.getIsdelay())) {
          delayStations.add(s.getStationCode());
        }
      }
    }

    String signal = "GREEN";
    if (delayStations.size() == 1) {
      signal = "YELLOW";
    } else if (delayStations.size() > 1) {
      signal = "RED";
    }

    return LineSignalDto.builder()
        .line(line)
        .signal(signal)
        .delayStations(delayStations)
        .curr_time(currTime)
        .sys_time(sysTime)
        .build();
  }

  // line 表每條線做一次 getSignal
  public List<LineSignalDto> getAllSignals() {
    Set<String> lines = new HashSet<>();
    for (LineEntity l : lineRepository.findAll()) {
      if (l.getLineCode() != null) {
        lines.add(l.getLineCode());
      }
    }
    List<LineSignalDto> result = new ArrayList<>();
    for (String l : lines) {
      result.add(getSignal(l));
    }
    return result;
  }

  // Map：key=線，value=該線站 list
  public Map<String, List<StationEntity>> getAllStation() {
    Map<String, List<StationEntity>> result = new HashMap<>();
    for (StationEntity s : findallStation()) {
      String key = s.getLineCode();
      if (key == null) {
        continue;
      }
      if (!result.containsKey(key)) {
        result.put(key, new ArrayList<>());
      }
      result.get(key).add(s);
    }
    return result;
  }
}