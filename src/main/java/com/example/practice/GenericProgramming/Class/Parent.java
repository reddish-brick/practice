package com.example.practice.GenericProgramming.Class;

public class Parent<T> {

  private T key;

  public Parent(T key) {
    this.key = key;
  }

  public T getKey() {
    return key;
  }

  public void setKey(T key) {
    this.key = key;
  }
}
