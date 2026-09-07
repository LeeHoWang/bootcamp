package com.bootcamp.self_bc_mtr.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bootcamp.self_bc_mtr.entity.LineEntity;
import com.bootcamp.self_bc_mtr.repository.LineRepository;

@Service 
public class LineService {
  private final LineRepository lineRepository;

  public LineService(LineRepository lineRepository){
    this.lineRepository = lineRepository;
  }

  public LineEntity save(LineEntity lineEntity){
    return lineRepository.save(lineEntity);
  }

  public Optional<LineEntity> get(String lineCode){
    return lineRepository.findByLineCode(lineCode);
  }

  public List<LineEntity> findallLine(){
    return lineRepository.findAll();
  }

  public void deleteLine(String lineCode){
    if (!lineRepository.existsById(lineCode)){
      throw new IllegalArgumentException("No such lineCode");
    }
    else {
      lineRepository.deleteById(lineCode);
    }
  }

}
