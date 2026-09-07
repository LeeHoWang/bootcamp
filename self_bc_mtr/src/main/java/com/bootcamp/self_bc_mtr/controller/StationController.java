package com.bootcamp.self_bc_mtr.controller;

import com.bootcamp.self_bc_mtr.dto.LineSignalDto;
import com.bootcamp.self_bc_mtr.dto.MtrDto;
import com.bootcamp.self_bc_mtr.dto.RespondDto;
import com.bootcamp.self_bc_mtr.entity.StationEntity;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.self_bc_mtr.service.StationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StationController{
  private StationService stationService;

  @GetMapping("/stationcode")
  public Optional<StationEntity> getStation(@RequestParam String stationCode) {
    return stationService.getStation(stationCode);
  }

  @GetMapping("/stationscode")
  public List<StationEntity> findAllStations() {
    return stationService.findallStation();
  }
  
  @GetMapping("/line/stations")
  public List<StationEntity> findlineCode(@RequestParam String lineCode) {
    return stationService.findlineCode(lineCode);
  }

  @DeleteMapping("/removed")
  public void removeStation(@RequestParam String stationCode){
    stationService.removeStation(stationCode);
  }
   
  @GetMapping("/trainTime")
  public MtrDto getMTR() {
      return stationService.getMtrDto();
  }

  @GetMapping("/nextTrain")
  public RespondDto getEarliestArrival(@RequestParam String line, @RequestParam String sta) {
      return stationService.getEarliestArrival(line, sta);
  }
  
  @GetMapping("/line/signal")
  public LineSignalDto getSignal(@RequestParam String line) {
      return stationService.getSignal(line);
  }
  
  @GetMapping("/line/signals")
  public List<LineSignalDto> getAllSignals() {
      return stationService.getAllSignals();
  }

  @GetMapping("/stations/map")
  public Map<String, List<StationEntity>> getAllStation() {
      return stationService.getAllStation();
  }
  
  @PostMapping("/save")
  public StationEntity insertStation(@RequestBody StationEntity stationEntity) {
      return stationService.insertStation(stationEntity);
  }

  
}