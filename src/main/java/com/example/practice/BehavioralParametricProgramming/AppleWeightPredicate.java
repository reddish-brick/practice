package com.example.practice.BehavioralParametricProgramming;

public class AppleWeightPredicate implements ApplePredicate {

  @Override
  public boolean filterApple(Apple apple) {
    return apple.getWeight() > 10;
  }
}
