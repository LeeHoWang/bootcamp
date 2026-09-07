package com.bootcamp.self_bc_mtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.self_bc_mtr.entity.StationEntity;
import java.util.List;
import java.util.Optional;


public interface StationRepository extends JpaRepository<StationEntity, Long>{
  Optional<StationEntity> findByStationCode(String StationCode);
  List<StationEntity> findByLineCode(String lineCode); 
}
