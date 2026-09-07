package com.bootcamp.self_bc_mtr.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.self_bc_mtr.entity.LineEntity;

public interface LineRepository extends JpaRepository<LineEntity, String>{
  Optional<LineEntity> findByLineCode(String lineCode);
  
} 
