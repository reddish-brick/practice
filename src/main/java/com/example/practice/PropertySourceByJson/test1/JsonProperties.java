package com.example.practice.PropertySourceByJson.test1;

import java.util.LinkedHashMap;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:data/configprops.json", factory = JsonPropertySourceFactory.class)
@ConfigurationProperties
public class JsonProperties {

  private int port;

  private boolean resend;

  private String host;

  private List<String> topics;

  private LinkedHashMap<String, ?> sender;
}
