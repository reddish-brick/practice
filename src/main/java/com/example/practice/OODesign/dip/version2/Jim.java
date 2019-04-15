package com.example.practice.OODesign.dip.version2;

//具体Jim人类
public class Jim implements People {

  public void eat(Fruit fruit) {
    System.out.println("Jim eat " + fruit.getName());
  }
}