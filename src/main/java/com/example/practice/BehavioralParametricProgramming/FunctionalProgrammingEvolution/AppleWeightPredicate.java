package com.example.practice.BehavioralParametricProgramming.FunctionalProgrammingEvolution;

public class AppleWeightPredicate implements ApplePredicate {

  @Override
  public boolean filterApple(Apple apple) {
    return apple.getWeight() > 10;
  }
}
