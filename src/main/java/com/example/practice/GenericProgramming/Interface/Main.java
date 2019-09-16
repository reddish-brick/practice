package com.example.practice.GenericProgramming.Interface;

public class Main {

  public static void main(String[] args) {
    Children1 children1 = new Children1();
    System.out.println(children1.print("string"));
    Children2 children2 = new Children2();
    System.out.println(children2.print(123));
  }


}
