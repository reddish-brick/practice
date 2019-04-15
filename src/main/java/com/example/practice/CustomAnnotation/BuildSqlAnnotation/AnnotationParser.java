package com.example.practice.CustomAnnotation.BuildSqlAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationParser {

  public static void main(String[] args) {
    Model model = new Model("123", "Hello");
    String sql = "select * from ";

    // 1：通过反射获取Class对象
    Class<?> cla = model.getClass();
    // 2：解析该类的类名上的注解：ClassAnno
    ClassAnnotation classAnno = cla.getAnnotation(ClassAnnotation.class);
    // 获取该注解的value值,即数据库表名：
    String classValue = classAnno.value();
    System.out.println("注解在类上的信息是：" + classValue);
    sql = sql + classValue + " where 1=1";

    // 3：解析该属性的属性上的注解：FieldAnno
    Field[] fields = cla.getDeclaredFields();
    for (Field field : fields) {
      try {
        FieldAnnotation fieldAnno = field.getAnnotation(FieldAnnotation.class);
        // 获取该属性的注解值，即该属性对应的数据库字段名
        String column = fieldAnno.value();
        System.out.println("注解在属性上的信息是：" + column);
        // 获取该属性的get方法名并且通过反射获取该属性的值
        String fieldName = field.getName();
        String methodName = "get"
            + fieldName.substring(0, 1).toUpperCase()
            + fieldName.substring(1);
        Method method = cla.getMethod(methodName);
        String methodValue = (String) method.invoke(model);
        // 拼sql查询条件
        sql = sql + " and " + column + " like '%" + methodValue + "%'";
      } catch (Exception e) {
      }
    }
    System.out.println("最终生成的sql是：" + sql);
  }
}
