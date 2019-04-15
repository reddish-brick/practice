package com.example.practice.OODesign.isp.version1;

//类C通过接口I依赖类D
public class C {

  public void depend1(I i) {
    i.method2();
    i.method3();
  }
}
