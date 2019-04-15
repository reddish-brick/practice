package com.example.practice.FunctionalInterfaceCoding.Supplier;

import java.util.function.Supplier;

//代表了 无参数，返回一个结果。
public class SupplierDemo_get {

  public static String supplierTest(Supplier<String> supplier) {
    return supplier.get();
  }

  public static void main(String[] args) {
    System.out.println(supplierTest(() -> "value".toUpperCase()));
  }
}
