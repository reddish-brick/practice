package com.example.practice.Jackson.SerializerAndDeserializer.Serializer;

import com.example.practice.Jackson.SerializerAndDeserializer.Item;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ItemSerializer extends JsonSerializer<Item> {

  @Override
  public void serialize(Item value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    jgen.writeNumberField("id", value.id);
    jgen.writeStringField("itemName", value.itemName);
    jgen.writeNumberField("owner", value.owner.id);
    jgen.writeEndObject();
  }
}
