package com.example.practice.Jackson.SerializerAndDeserializer;

import com.example.practice.Jackson.SerializerAndDeserializer.Item.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
    //序列化
    Item myItem = new Item(1, "theItem", new User(2, "theUser"));
    System.out.println(new ObjectMapper().writeValueAsString(myItem));

    //反序列化
    System.out.println(new ObjectMapper()
        .readValue("{\"id\":1,\"itemName\":\"theItem\",\"owner\":2}", Item.class).toString());
  }


}
