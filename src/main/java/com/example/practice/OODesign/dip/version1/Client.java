package com.example.practice.OODesign.dip.version1;

public class Client {

  public static void main(String[] args) {
    Jim jim = new Jim();
    Apple apple = new Apple();
    jim.eat(apple);
  }
}