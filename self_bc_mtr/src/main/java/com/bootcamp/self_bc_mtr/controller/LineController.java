package com.bootcamp.self_bc_mtr.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.self_bc_mtr.entity.LineEntity;
import com.bootcamp.self_bc_mtr.service.LineService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LineController {
  public LineService lineService;

  public LineController(LineService lineService){
    this.lineService = lineService;
  }

  @PostMapping("/saveline")
  public LineEntity save(@RequestBody LineEntity lineEntity) {
      return lineService.save(lineEntity);
  }

  @GetMapping("/line")
  public Optional<LineEntity> get(@RequestParam String lineCode) {
      return lineService.get(lineCode);
  }
  
  @GetMapping("/lines")
  public List<LineEntity> findallLine() {
      return lineService.findallLine();
  }
  
  @DeleteMapping("/lines")
  public void deleteLine(@RequestParam String lineCode) {
    lineService.deleteLine(lineCode);
  }

}
