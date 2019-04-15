package com.example.practice.OODesign.isp.version2;

public class B implements I1, I2 {

  @Override
  public void method1() {
    System.out.println("类B实现了接口I的方法1");
  }

  @Override
  public void method2() {
    System.out.println("类B实现了接口I的方法2");
  }
}