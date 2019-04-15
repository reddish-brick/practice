package com.example.practice.Jackson.TreeModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class ReadJson {

  private static final String GENERIC_BINDING = "{\"key1\":{\"name\":\"name2\",\"type\":2},\"key2\":{\"name\":\"name3\",\"type\":3}}";
  private static final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";

  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);
    //path与get作用相同,但是当找不到该节点的时候,返回missing node而不是Null.
    String treekey2value = rootNode.path("treekey2").asText();//
    System.out.println("treekey2value:" + treekey2value);
    JsonNode childrenNode = rootNode.path("children");
    String childkey1Value = childrenNode.get(0).path("childkey1").asText();
    System.out.println("childkey1Value:" + childkey1Value);

    //创建根节点
    ObjectNode root = mapper.createObjectNode();
    //创建子节点1
    ObjectNode node1 = mapper.createObjectNode();
    node1.put("nodekey1", 1);
    node1.put("nodekey2", 2);
    //绑定子节点1
    root.put("child", node1);
    //数组节点
    ArrayNode arrayNode = mapper.createArrayNode();
    arrayNode.add(node1);
    arrayNode.add(1);
    //绑定数组节点
    root.put("arraynode", arrayNode);
    //JSON读到树节点
    JsonNode valueToTreeNode = mapper.valueToTree(TREE_MODEL_BINDING);
    //绑定JSON节点
    root.put("valuetotreenode", valueToTreeNode);
    //JSON绑定到JSON节点对象
    JsonNode bindJsonNode = mapper.readValue(GENERIC_BINDING, JsonNode.class);//绑定JSON到JSON节点对象.
    //绑定JSON节点
    root.put("bindJsonNode", bindJsonNode);
    System.out.println(mapper.writeValueAsString(root));
  }
}
