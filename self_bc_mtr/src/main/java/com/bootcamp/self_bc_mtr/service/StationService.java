package com.bootcamp.self_bc_mtr.service;

import com.bootcamp.self_bc_mtr.repository.StationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.self_bc_mtr.dto.MtrDto;
import com.bootcamp.self_bc_mtr.dto.RespondDto;
import com.bootcamp.self_bc_mtr.entity.StationEntity;

@Service
public class StationService{
  private final RestTemplate restTemplate;
  private final StationRepository stationRepository;

  public StationService(StationRepository stationRepository, RestTemplate restTemplate) {
    this.stationRepository = stationRepository;
    this.restTemplate = restTemplate;
  }

  public StationEntity save(StationEntity stationEntity){
    return stationRepository.save(stationEntity);
  }

  public Optional<StationEntity> getStation(String stationCode){
    return stationRepository.findByStationCode(stationCode);
  }

  public List<StationEntity> findallStation () {
    return stationRepository.findAll();
  }

  public List<StationEntity> findlineCode(String lineCode){
    return stationRepository.findByLineCode(lineCode);
  }

  public void removebycode(String stationCode){
    Optional<StationEntity> result = stationRepository.findByStationCode(stationCode);
    if (result.isPresent()){
      stationRepository.deleteById(result.get().getId());
    } 
    else {
      throw new IllegalArgumentException("stationCode not exist"); 
    }
  }

  public MtrDto getMtrDto(){
    String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line=TKL&sta=TKO";
    MtrDto result = restTemplate.getForObject(url, MtrDto.class);
    return result;
  }

  public RespondDto getEarliestArrival(String line, String sta){
    String url = "https://rt.data.gov.hk/v1/transport/mtr/getSchedule.php?line="+line+"&sta="+sta;

    Optional<StationEntity> station = getStation(sta);
    if (station.isEmpty()){
      throw new IllegalArgumentException("Station not in database");
    }

    StationEntity s = station.get();
    if (!s.getLineCode().equals(line)){
      throw new IllegalArgumentException("This station does not belong to this line.");
    }

    MtrDto result = restTemplate.getForObject(url, MtrDto.class);
    if (result == null || result.getData() == null){
      throw new IllegalArgumentException("invalid input");
    }

    MtrDto.MtrStopData stopData = result.getData().get(line+"-"+sta);
    List<RespondDto.Train> trains = new ArrayList<>();
    if (stopData == null){
      throw new IllegalArgumentException("invalid line/station code");
    }
    if (stopData.UP != null && !stopData.UP.isEmpty()){
         MtrDto.MtrArrival earliestUP = stopData.UP.get(0);

         RespondDto.Train upTrain = 
          RespondDto.Train.builder()
                          .destination(earliestUP.dest)
                          .arrivalTime(earliestUP.time)
                          .direction("UP")
                          .build();

         trains.add(upTrain); 
      }
      if (stopData.DOWN != null && !stopData.DOWN.isEmpty()){
         MtrDto.MtrArrival earliestDOWN = stopData.DOWN.get(0);

         RespondDto.Train downTrain = 
          RespondDto.Train.builder()
                          .destination(earliestDOWN.dest)
                          .arrivalTime(earliestDOWN.time)
                          .direction("DOWN")
                          .build();

         trains.add(downTrain); 
      }  
      return RespondDto.builder()
                          .curr_time(result.getCurr_time())
                          .sys_time(result.getSys_time())
                          .currentStation(sta)
                          .trains(trains)
                          .build();

  }
  
}

