package com.example.practice.OODesign.dip.version2;

public class Client {

  public static void main(String[] args) {
    People jim = new Jim();
    Fruit apple = new Apple();
    Fruit Banana = new Banana();//这里符合了里氏替换原则
    jim.eat(apple);
    jim.eat(Banana);
  }
}