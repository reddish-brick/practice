package com.example.practice.DesignPattern.CommandPattern.CalculatorExample;

public class Client {

  public static void main(String[] args) {
    //1：组装命令和接收者
    CalculatorReceiver receiver = new CalculatorReceiver();
    Command addCommand = new AddCommand(receiver, 5);
    Command subtractCommand = new SubtractCommand(receiver, 2);

    //2：把命令设置到持有者，就是计算器里面
    CalculatorInvoker calculatorInvoker = new CalculatorInvoker();
    calculatorInvoker.setAddCommand(addCommand);
    calculatorInvoker.setSubtractCommand(subtractCommand);

    //3:模拟按下按钮，测试一下
    calculatorInvoker.addOperation();
    calculatorInvoker.subtractOperation();
    System.out.println(receiver.getResult());

    //测试撤消
    calculatorInvoker.undo();
    System.out.println(receiver.getResult());

    //测试恢复
    calculatorInvoker.redo();
    System.out.println(receiver.getResult());
  }
}
