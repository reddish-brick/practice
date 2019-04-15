package com.example.practice.OODesign.isp.version1;

public class B implements I {

  @Override
  public void method1() {
    System.out.println("类B实现了接口I的方法1");
  }

  @Override
  public void method2() {
    System.out.println("类B实现了接口I的方法2");
  }

  @Override
  public void method3() {//类B并不需要接口I的方法3功能，但是由于实现接口I，所以不得不实现方法3
    //在这里写一个空方法
  }
}
