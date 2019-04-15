package com.example.practice.OODesign.isp.version1;

public class Client {

  public static void main(String[] args) {
    A a = new A();
    I i1 = new B();
    a.depend1(i1);

    C c = new C();
    I i2 = new D();
    c.depend1(i2);
  }
}
