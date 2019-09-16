package com.example.practice.Annotation.LogAnnotation;

import java.lang.reflect.Field;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

  @Pointcut("@annotation(com.example.practice.Annotation.LogAnnotation.LogAnnotation)")
  private void cut() {
  }

  /**
   * 定制一个环绕通知
   */
  @Around("cut()")
  public void advice(ProceedingJoinPoint joinPoint) {
    System.out.println("around之开始");
    try {
      joinPoint.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    System.out.println("around之结束");
  }

  //当想获得注解里面的属性，可以直接注入该注解
  @Before("cut()&&@annotation(logAnnotation)")
  public void record(JoinPoint joinPoint, LogAnnotation logAnnotation)
      throws NoSuchFieldException, IllegalAccessException {
    //通过反射给目标对象属性赋值
    Object target = joinPoint.getTarget();
    Field name = target.getClass().getDeclaredField("name");
    name.setAccessible(true);
    name.set(target, "小汤");

    System.out.println("before: " + logAnnotation.value());
  }

  @After("cut()&&@annotation(logAnnotation)")
  public void after(JoinPoint joinPoint, LogAnnotation logAnnotation) {
    System.out.println("after: " + logAnnotation.value());
  }
}
