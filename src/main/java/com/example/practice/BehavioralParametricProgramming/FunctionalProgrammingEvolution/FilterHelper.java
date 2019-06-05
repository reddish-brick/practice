package com.example.practice.BehavioralParametricProgramming.FunctionalProgrammingEvolution;

import java.util.ArrayList;
import java.util.List;

public class FilterHelper {

  public static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate) {
    List<Apple> list = new ArrayList<>();
    for (Apple apple : apples) {
      if (applePredicate.filterApple(apple)) {
        list.add(apple);
      }
    }
    return list;
  }

  public static <T> List<T> filter(List<T> objects, Predicate<T> predicate) {
    List<T> list = new ArrayList<>();
    for (T t : objects) {
      if (predicate.filter(t)) {
        list.add(t);
      }
    }
    return list;
  }
}
