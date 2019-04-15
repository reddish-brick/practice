package com.example.practice.Jackson.DataBinding;

import com.example.practice.Jackson.DataBinding.Country.Province;
import com.example.practice.Jackson.DataBinding.Country.Province.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonToBean {

  public static void main(String[] args) throws IOException {
    jsonToObject();
    jsonToListObject();
  }

  private static void jsonToObject() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File jsonFile = new File("country.json");
    //当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
    //因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    Country country = mapper.readValue(jsonFile, Country.class);
    System.out.println(country.getCountryName() + country.getEstablishTime());
    List<Province> provinces = country.getProvinces();
    for (Province province : provinces) {
      System.out.println(
          "province:" + province.getName() + "\n" + "birthDate:" + province.getBirthDate());
      for (City city : province.getCities()) {
        System.out.println(city.getId() + " " + city.getCityName());
      }
    }
  }

  public static void jsonToListObject() throws IOException {
    City city1 = new City();
    city1.setId(1);
    city1.setCityName("gz");
    City city2 = new City();
    city2.setId(2);
    city2.setCityName("dg");

    List<City> cities = new ArrayList<City>();
    cities.add(city1);
    cities.add(city2);

    ObjectMapper mapper = new ObjectMapper();
    String listJsonStr = mapper.writeValueAsString(cities);
    System.out.println(listJsonStr);
    List<City> list = mapper.readValue(listJsonStr, new TypeReference<List<City>>() {
    });
    for (City city : list) {
      System.out.println("id:" + city.getId() + " cityName:" + city.getCityName());
    }
  }
}
