package com.example.practice.Jackson.DataBinding;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Country {

  private Integer id;
  private String countryName;
  private Date establishTime;
  private List<Province> provinces;
  private String[] lakes;
  private Map<String, String> forest = new HashMap<String, String>();

  @Data
  @RequiredArgsConstructor
  @AllArgsConstructor
  public static class Province {

    private Integer id;
    private String name;
    private Date birthDate;
    private List<City> cities;

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class City {

      private Integer id;
      private String cityName;
    }
  }
}
