package com.bootcamp.self_bc_mtr.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LineSignalDto {
  public String line;
  public String signal;
  public List<String> delayStations;
  public String curr_time;
  public String sys_time;
}
