package com.example.practice.Jackson.StreamingAPI;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.File;
import java.io.IOException;

public class GenerateJson {

  public static void main(String[] args) throws IOException {
    JsonFactory jfactory = new JsonFactory();
    JsonGenerator jGenerator = jfactory.createGenerator(new File(
        "c:\\user.json"), JsonEncoding.UTF8);
    jGenerator.writeStartObject(); // {
    jGenerator.writeStringField("name", "mkyong"); // "name" : "mkyong"
    jGenerator.writeNumberField("age", 29); // "age" : 29
    jGenerator.writeFieldName("messages"); // "messages" :
    jGenerator.writeStartArray(); // [
    jGenerator.writeString("msg 1"); // "msg 1"
    jGenerator.writeString("msg 2"); // "msg 2"
    jGenerator.writeString("msg 3"); // "msg 3"
    jGenerator.writeEndArray(); // ]
    jGenerator.writeEndObject(); // }
    jGenerator.close();
  }
}
