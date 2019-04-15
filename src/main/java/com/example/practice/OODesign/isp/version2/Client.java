package com.example.practice.OODesign.isp.version2;


public class Client {

  public static void main(String[] args) {
    B b = new B();
    b.method1();
    b.method2();

    D d = new D();
    d.method2();
    d.method3();
  }
}
