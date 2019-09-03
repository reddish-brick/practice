package com.example.practice.DesignPattern.AdapterPattern;

/**
 * 已经存在的接口，这个接口需要被适配
 */
public class Adaptee {

  /**
   * 示意方法，原本已经存在，已经实现的方法
   */
  public void specificRequest() {
    System.out.println("Adaptee");
  }
}