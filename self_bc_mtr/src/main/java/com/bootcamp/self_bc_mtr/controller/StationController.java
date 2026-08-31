package com.bootcamp.self_bc_mtr.controller;

import com.bootcamp.self_bc_mtr.dto.LineSignalDto;
import com.bootcamp.self_bc_mtr.dto.MtrDto;
import com.bootcamp.self_bc_mtr.dto.RespondDto;
import com.bootcamp.self_bc_mtr.entity.StationEntity;
import com.bootcamp.self_bc_mtr.repository.StationRepository;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.self_bc_mtr.service.StationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StationController{
  private StationService stationService;

  public StationController(StationRepository stationRepository, StationService stationService){
    this.stationService = stationService;
  }

  @PostMapping("/save")
  public StationEntity saveStation(@RequestBody StationEntity stationEntity) {
    return stationService.save(stationEntity);
  }

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
  public void removebycode(@RequestParam String stationCode){
    stationService.removebycode(stationCode);
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
  

}