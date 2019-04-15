package com.example.practice.OODesign.isp.version2;

public class D implements I2, I3 {

  @Override
  public void method2() {
    System.out.println("类D实现了接口I的方法2");
  }

  @Override
  public void method3() {
    System.out.println("类D实现了接口I的方法3");
  }
}