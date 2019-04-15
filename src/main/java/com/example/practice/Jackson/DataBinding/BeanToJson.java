package com.example.practice.Jackson.DataBinding;

import com.example.practice.Jackson.DataBinding.Country.Province;
import com.example.practice.Jackson.DataBinding.Country.Province.City;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BeanToJson {

  public static void main(String[] args) throws IOException, ParseException {
    // 使用ObjectMapper转化对象为Json
    ObjectMapper mapper = new ObjectMapper();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    mapper.setDateFormat(dateFormat);   //设置日期序列化格式
    City city1 = new City();
    city1.setId(1);
    city1.setCityName("gz");
    City city2 = new City();
    city2.setId(2);
    city2.setCityName("dg");

    Province province = new Province();
    province.setId(1);
    province.setName("GD");
    province.setBirthDate(new Date());
    List<City> cities = new ArrayList<>();
    cities.add(city1);
    cities.add(city2);
    province.setCities(cities);

    Country country = new Country();
    country.setCountryName("China");
    country.setId(1);
    country.setEstablishTime(dateFormat.parse("1949-10-01"));
    country.setLakes(new String[]{"Qinghai Lake", "Poyang Lake", "Dongting Lake", "Taihu Lake"});
    HashMap<String, String> forest = new HashMap<>();
    forest.put("no.1", "dxal");
    forest.put("no.2", "xxal");
    country.setForest(forest);
    List<Province> provinces = new ArrayList<>();
    provinces.add(province);
    country.setProvinces(provinces);

    mapper.configure(SerializationFeature.INDENT_OUTPUT,
        true);     // 为了使JSON视觉上的可读性，在生产中不需如此，会增大Json的内容
    mapper.setSerializationInclusion(Include.NON_EMPTY);  // 配置mapper忽略空属性
    mapper.writeValue(new File("country.json"),
        country);  // 默认情况，Jackson使用Java属性字段名称作为 Json的属性名称,也可以使用Jackson annotations(注解)改变Json属性名称
  }
}
