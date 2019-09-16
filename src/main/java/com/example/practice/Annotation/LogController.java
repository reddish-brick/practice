package com.example.practice.Annotation;

import com.example.practice.Annotation.LogAnnotation.LogAnnotation;
import com.example.practice.Annotation.PermissionAnnotation.PermissionContextAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

  private String name;

  @LogAnnotation("log")
  @PermissionContextAnnotation(service = "iam", resourceId = "users/{id}", action = "GetUser")
  @GetMapping(value = "/dogs")
  public void getAllUserInfo() {
    System.out.println("方法执行逻辑 " + name);
  }
}
