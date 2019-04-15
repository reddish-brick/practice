package com.example.practice.CustomAnnotation.BuildSqlAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 元注解： 说明子类可以继承父类中的该注解
@Inherited
// 元注解：定义注解的作用目标:ElementType.FIELD(字段、枚举的常量)
@Target(ElementType.FIELD)
// 元注解：定义注解的保留策略:RetentionPolicy.RUNTIME(注解会在class字节码文件中存在，在运行时可以通过反射获取到)
@Retention(RetentionPolicy.RUNTIME)
// 元注解：说明该注解将被包含在javadoc中
@Documented
public @interface FieldAnnotation {

  String value() default "";
}
