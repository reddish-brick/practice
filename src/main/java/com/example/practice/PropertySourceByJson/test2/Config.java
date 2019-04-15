package com.example.practice.PropertySourceByJson.test2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//  @Value("classpath:data/data.json")
//  private File configFile;
//
//  @Bean
//  public PersonCfg readServerConfig() throws IOException {
//    return new ObjectMapper().readValue(configFile, PersonCfg.class);
//  }

  @Bean
  public PersonCfg readServerConfig() throws IOException {
    TypeReference<PersonCfg> typeReference = new TypeReference<PersonCfg>() {
    };
    InputStream inputStream = TypeReference.class.getResourceAsStream("/data/data.json");

    return new ObjectMapper().readValue(inputStream, typeReference);
  }
}
