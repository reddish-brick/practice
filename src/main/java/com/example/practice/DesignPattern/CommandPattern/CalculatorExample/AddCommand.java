package com.example.practice.DesignPattern.CommandPattern.CalculatorExample;

public class AddCommand implements Command {

  private int number;
  private CalculatorReceiver calculatorReceiver;

  public AddCommand(CalculatorReceiver calculatorReceiver, int number) {
    this.calculatorReceiver = calculatorReceiver;
    this.number = number;
  }

  @Override
  public void execute() {
    calculatorReceiver.add(number);
  }

  @Override
  public void undo() {
    calculatorReceiver.subtract(number);
  }
}
