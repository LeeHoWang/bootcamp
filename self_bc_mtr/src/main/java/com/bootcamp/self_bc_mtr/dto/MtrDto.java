package com.bootcamp.self_bc_mtr.dto;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MtrDto {
  public String sys_time;
  public String curr_time;
  public Map<String, MtrStopData> data;
  public Integer status;
  public String message;
  public String isdelay;

  public static class MtrStopData{
    public List<MtrArrival> UP;
    public List<MtrArrival> DOWN;
  }

  public static class MtrArrival{
    public String dest;
    public String time;
  }

}
