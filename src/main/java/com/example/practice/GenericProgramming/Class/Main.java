package com.example.practice.GenericProgramming.Class;

public class Main {

  public static void main(String[] args) {
    Parent parent1 = new Parent<Integer>(123);
    System.out.println("泛型测试 Integer: " + parent1.getKey());
    System.out.println("==================================");
    Parent parent2 = new Parent<String>("字符串");
    System.out.println("泛型测试 String: " + parent2.getKey());
    System.out.println("==================================");
    Parent parent3 = new Parent("字符串");
    Parent parent4 = new Parent(123);
    System.out.println("泛型测试 : " + parent3.getKey());
    System.out.println("泛型测试 : " + parent4.getKey());
    System.out.println("==================================");
    print(new Parent<>("String"));
    print(new Parent<>(123));
  }

  public static void print(Parent<?> parent) {
    System.out.println(parent.getKey());
  }


}
