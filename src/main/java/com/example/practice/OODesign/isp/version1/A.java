package com.example.practice.OODesign.isp.version1;

//类A通过接口I依赖类B
public class A {

  public void depend1(I i) {
    i.method1();
    i.method2();
  }
}
