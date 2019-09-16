package com.example.practice.Annotation.BuildSqlAnnotation;

@ClassAnnotation("product_model")
// 注解在类上，标识该实体对应的数据库表名
public class Model {

  @FieldAnnotation("product_id")
  // 注解在属性上，标识该属性对应的数据库字段名
  private String id;
  @FieldAnnotation("product_name")
  private String name;

  public Model(String id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
