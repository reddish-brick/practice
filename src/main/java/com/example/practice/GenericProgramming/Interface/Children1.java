package com.example.practice.GenericProgramming.Interface;

public class Children1 implements Parent<String> {

  @Override
  public String print(String s) {
    return s;
  }
}
