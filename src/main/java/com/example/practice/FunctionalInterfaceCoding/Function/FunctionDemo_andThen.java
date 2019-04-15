package com.example.practice.FunctionalInterfaceCoding.Function;

import java.util.function.Function;

//Function接口 接受一个输入参数T，返回一个结果R。
public class FunctionDemo_andThen {

  static Integer modifyTheValue(String valueToBeOperated, Function<String, Integer> function1,
      Function<Integer, Integer> function2) {
    //value作为function1的参数，返回一个结果，该结果作为function2的参数，返回一个最终结果
    return function1.andThen(function2).apply(valueToBeOperated);
  }

  public static void main(String[] args) {
    System.out.println(
        modifyTheValue("10", value -> value.length(), value -> Integer.valueOf(value + 5)));
  }

}
