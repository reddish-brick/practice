package com.example.practice.Jackson.TreeModel;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateJson {

  public static void main(String[] args) throws IOException {
    //创建一个节点工厂,为我们提供所有节点
    JsonNodeFactory factory = new JsonNodeFactory(false);
    //创建一个json factory来写tree modle为json
    JsonFactory jsonFactory = new JsonFactory();
    //创建一个json生成器
    JsonGenerator generator = jsonFactory
        .createGenerator(new FileWriter(new File("country2.json")));
    //注意，默认情况下对象映射器不会指定根节点，下面设根节点为country
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode country = factory.objectNode();
    country.put("id", 1);
    country.put("countryName", "China");
    country.put("establishTime", "1949-10-01");

    ArrayNode provinces = factory.arrayNode();
    ObjectNode province = factory.objectNode();
    ObjectNode city1 = factory.objectNode();
    city1.put("id", 1);
    city1.put("cityName", "gz");
    ObjectNode city2 = factory.objectNode();
    city2.put("id", 1);
    city2.put("cityName", "dg");
    ArrayNode cities = factory.arrayNode();
    cities.add(city1).add(city2);
    province.put("cities", cities);
    provinces.add(province);
    country.put("provinces", provinces);

    ArrayNode lakes = factory.arrayNode();
    lakes.add("QingHai Lake").add("Poyang Lake").add("Dongting Lake").add("Taihu Lake");
    country.put("lakes", lakes);

    ObjectNode forest = factory.objectNode();
    forest.put("no.1", "dxal");
    forest.put("no.2", "xxal");
    country.put("forest", forest);

    mapper.setSerializationInclusion(Include.NON_EMPTY);  // 配置mapper忽略空属性
    mapper.writeTree(generator, country);
  }
}
