package com.example.practice.Annotation.SerializableAnnotation;

@JsonSerializable
public class Person {

  @JsonElement
  private String firstName;
  @JsonElement
  private String lastName;
  @JsonElement
  private Integer age;
  @JsonElement
  private String address;

  public Person(String firstName, String lastName, Integer age, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
  }

  @Init
  private void initNames() {
    this.firstName = this.firstName.substring(0, 1).toUpperCase()
        + this.firstName.substring(1);
    this.lastName = this.lastName.substring(0, 1).toUpperCase()
        + this.lastName.substring(1);
  }
}
