package com.bootcamp.self_bc_mtr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Station")
@Getter
@Setter
public class StationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;
  private String lineCode;
  private String stationCode;
  private String stationDescription;
  private String previous;
  private String next;
}
