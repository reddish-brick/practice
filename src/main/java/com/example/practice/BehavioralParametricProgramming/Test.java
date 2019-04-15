package com.example.practice.BehavioralParametricProgramming;

import java.util.Arrays;
import java.util.List;

import static com.example.practice.BehavioralParametricProgramming.FilterHelper.filter;
import static com.example.practice.BehavioralParametricProgramming.FilterHelper.filterApples;

public class Test {

  public static void main(String[] args) {
    List<Apple> apples = Arrays.asList(Apple.builder().color("red").weight(8d).build(),
        Apple.builder().color("blue").weight(15d).build(),
        Apple.builder().color("blue").weight(6d).build(),
        Apple.builder().color("red").weight(12d).build());
    //1、使用具体类
    List<Apple> redApples = filterApples(apples, new AppleRedPredicate());
    List<Apple> weightMoreThan10Apples = filterApples(apples, new AppleWeightPredicate());
    //2、使用匿名类
    List<Apple> weightMoreThan10AndRedApples = filterApples(apples, new ApplePredicate() {
      @Override
      public boolean filterApple(Apple apple) {
        return apple.getColor().equals("red") && apple.getWeight() > 10;
      }
    });
    //3、使用lambda表达式
    List<Apple> blueApples = filterApples(apples, (Apple apple) -> apple.getColor().equals("blue"));

    List<Apple> weightMoreThan10AndBlueApples = filter(apples,
        (Apple apple) -> "blue".equals(apple.getColor()) && apple.getWeight() > 10);
    List<Integer> dataMoreThan3 = filter(Arrays.asList(1, 2, 3, 4, 5, 6),
        (Integer integer) -> integer > 3);

    printAllResult(redApples, weightMoreThan10Apples, weightMoreThan10AndRedApples, blueApples,
        weightMoreThan10AndBlueApples, dataMoreThan3);
  }

  private static void printAllResult(List<Apple> redApples, List<Apple> weightMoreThan10Apples,
      List<Apple> weightMoreThan10AndRedApples, List<Apple> blueApples,
      List<Apple> weightMoreThan10AndBlueApples, List<Integer> dataMoreThan3) {
    System.out.println("=======================red apples=====================");
    System.out.println(redApples.toString());
    System.out.println("=======================weight more than 10 apples=====================");
    System.out.println(weightMoreThan10Apples.toString());
    System.out
        .println("=======================weight more than 10 and red apples=====================");
    System.out.println(weightMoreThan10AndRedApples.toString());
    System.out.println("=======================blue apples=====================");
    System.out.println(blueApples.toString());
    System.out
        .println("=======================weight more than 10 and blue apples=====================");
    System.out.println(weightMoreThan10AndBlueApples.toString());
    System.out
        .println("=======================data more than 3=====================");
    System.out.println(dataMoreThan3.toString());
  }
}
