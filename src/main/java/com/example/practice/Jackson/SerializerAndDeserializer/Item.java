package com.example.practice.Jackson.SerializerAndDeserializer;

import com.example.practice.Jackson.SerializerAndDeserializer.Deserializer.ItemDeserializer;
import com.example.practice.Jackson.SerializerAndDeserializer.Serializer.ItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@JsonSerialize(using = ItemSerializer.class)
@JsonDeserialize(using = ItemDeserializer.class)
public class Item {

  public int id;
  public String itemName;
  public User owner;

  @AllArgsConstructor
  @RequiredArgsConstructor
  @Data
  public static class User {

    public int id;
    public String name;
  }
}
