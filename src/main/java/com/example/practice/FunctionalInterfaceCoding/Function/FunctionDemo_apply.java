package com.example.practice.FunctionalInterfaceCoding.Function;

import java.util.function.Function;

//Function接口 接受一个输入参数T，返回一个结果R。
public class FunctionDemo_apply {

  static int modifyTheValue(String valueToBeOperated, Function<String, Integer> function) {
    return function.apply(valueToBeOperated);
  }

  public static void main(String[] args) {
    String number = "10";

    // 使用lambda表达式实现函数式接口
    // (x)->(x)+20 输入一个参数x，进行加法运算，返回一个结果
    // 所以该lambda表达式可以实现Function接口
    int res1 = modifyTheValue(number, (x) -> Integer.valueOf(x) + 20);
    System.out.println(res1); // 30

    //  使用匿名内部类实现
    int res2 = modifyTheValue(number, new Function<String, Integer>() {
      @Override
      public Integer apply(String t) {
        return Integer.valueOf(t) + 20;
      }
    });
    System.out.println(res2); // 30
  }

}
