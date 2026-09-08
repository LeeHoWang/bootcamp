package com.bootcamp.self_bc_mtr.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RespondDto {
  public String curr_time;
  public String sys_time;
  public String currentStation;
  public List<Train> trains;

  @Builder
  public static class Train {
    public String destination;
    public String arrivalTime; 
    public String direction; 
  }

}
