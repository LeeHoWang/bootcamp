package com.bootcamp.self_bc_mtr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="line")
@Getter
@Setter
public class LineEntity {
  @Id
  private String lineCode;
  private String lineDescription;
}