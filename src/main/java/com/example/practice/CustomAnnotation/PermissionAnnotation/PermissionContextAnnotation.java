package com.example.practice.CustomAnnotation.PermissionAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PermissionContextAnnotation {

  String service() default "";

  String resourceId() default "";

  String action() default "";
}
