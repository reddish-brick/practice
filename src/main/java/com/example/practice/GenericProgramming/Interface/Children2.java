package com.example.practice.GenericProgramming.Interface;

public class Children2 implements Parent<Integer> {


  @Override
  public Integer print(Integer integer) {
    return integer * 2;
  }
}
