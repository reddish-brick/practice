package com.example.practice.PropertySourceByJson.test2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonCfg {

  private String name;
  private int age;
  private String city;
  private List<Contact> contacts;
  private List<BusinessLineName> businessLineNames;


  @Data
  public static class Contact {

    private String phone;
    private String email;
  }

  @Data
  public static class BusinessLineName {

    @JsonProperty("salesOrganization")
    private String salesOrganization;

    @JsonProperty("distributionChannel")
    private String distributionChannel;

    @JsonProperty("division")
    private String division;

    @JsonProperty("salesGroup")
    private String salesGroup;

    @JsonProperty("customerGroup")
    private String customerGroup;

    @JsonProperty("businessLineName")
    private String businessLineName;
  }


}
