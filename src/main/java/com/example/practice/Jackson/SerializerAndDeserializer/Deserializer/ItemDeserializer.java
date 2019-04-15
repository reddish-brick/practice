package com.example.practice.Jackson.SerializerAndDeserializer.Deserializer;

import com.example.practice.Jackson.SerializerAndDeserializer.Item;
import com.example.practice.Jackson.SerializerAndDeserializer.Item.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {

  @Override
  public Item deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    int id = (Integer) ((IntNode) node.get("id")).numberValue();
    String itemName = node.get("itemName").asText();
    int userId = (Integer) ((IntNode) node.get("id")).numberValue();
    return new Item(id, itemName, new User(userId, null));
  }
}
