package com.example.practice.BehavioralParametricProgramming;

public class AppleRedPredicate implements ApplePredicate {

  @Override
  public boolean filterApple(Apple apple) {
    return apple.getColor().equals("red");
  }
}
