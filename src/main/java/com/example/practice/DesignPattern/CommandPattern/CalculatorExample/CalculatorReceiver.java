package com.example.practice.DesignPattern.CommandPattern.CalculatorExample;

public class CalculatorReceiver {

  /**
   * 记录运算的结果
   */
  private int result;

  public int getResult() {
    return result;
  }

  public void add(int num) {
    result += num;
  }

  public void subtract(int num) {
    result -= num;
  }
}
