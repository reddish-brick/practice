package com.example.practice.FunctionalInterfaceCoding.Consumer;

import java.util.function.Consumer;

//代表了 接受一个输入参数并且无返回的操作
public class ConsumerDemo {

  public static void modifyTheValue(String valueToBeOperated, Consumer<String> consumer) {
    consumer.accept(valueToBeOperated);
  }

  public static void main(String[] args) {
    modifyTheValue("string", value -> System.out.println(value.toUpperCase()));
  }
}
