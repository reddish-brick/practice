package com.example.practice.OODesign.isp.version1;

//类C通过接口I依赖类D
public class D implements I {

  @Override
  public void method1() {//类D并不需要接口I的方法1功能，但是由于实现接口I，所以不得不实现方法1
    //在这里写一个空方法
  }

  @Override
  public void method2() {
    System.out.println("类D实现了接口I的方法2");
  }

  @Override
  public void method3() {
    System.out.println("类D实现了接口I的方法3");
  }
}
