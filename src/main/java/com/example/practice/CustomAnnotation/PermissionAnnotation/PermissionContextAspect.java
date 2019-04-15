package com.example.practice.CustomAnnotation.PermissionAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-99)//控制多个Aspect的执行顺序，越小越先执行
@Component
public class PermissionContextAspect {

  //只拦截标有注解 PermissionContextAnnotation 的方法
  @Pointcut("@annotation(com.example.practice.CustomAnnotation.PermissionAnnotation.PermissionContextAnnotation)")
  public void checkPermission() {
  }

  @Before("checkPermission()")
  public void doBefore(JoinPoint joinPoint) {

    //方法注解
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    //取得 PermissionContextAnnotation 注解属性（值）信息
    PermissionContextAnnotation permissionContextAnnotationAnnotation
        = methodSignature.getMethod().getAnnotation(PermissionContextAnnotation.class);
    String service = permissionContextAnnotationAnnotation.service();
    String resourceId = permissionContextAnnotationAnnotation.resourceId();
    String action = permissionContextAnnotationAnnotation.action();
    //iam users/{id} GetUser
    System.out.println(service + " " + resourceId + " " + action);
  }
}
