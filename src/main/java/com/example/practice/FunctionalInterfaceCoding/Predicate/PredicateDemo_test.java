package com.example.practice.FunctionalInterfaceCoding.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//代表了 接受一个输入参数，返回一个布尔值结果
public class PredicateDemo_test {

  public static Boolean predicateTest1(Integer valueToBeOperated, Predicate<Integer> predicate) {
    return predicate.test(valueToBeOperated);
  }

  public static void predicateTest2(List<Integer> list, Predicate<Integer> predicate) {
    for (Integer integer : list) {
      if (predicate.test(integer)) {
        System.out.println(integer + " ");
      }
    }
  }

  public static Boolean predicateTest3(String value, Predicate<String> predicate) {
    return predicate.test(value);
  }


  public static void main(String[] args) {
    System.out.println(predicateTest1(3, value -> value > 5));
    System.out.println("===============================");
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    System.out.println("输出所有数据:");
    predicateTest2(list, value -> true);
    System.out.println("\n输出所有偶数:");
    predicateTest2(list, value -> value % 2 == 0);
    System.out.println("\n输出大于 3 的所有数字:");
    predicateTest2(list, n -> n > 3);
    System.out.println("===============================");
    if (predicateTest3("value", value -> !value.isEmpty() && value.length() < 3)) {
      System.out.println("名字输入正确");
    }
    System.out.println("名字输入错误");
  }
}
