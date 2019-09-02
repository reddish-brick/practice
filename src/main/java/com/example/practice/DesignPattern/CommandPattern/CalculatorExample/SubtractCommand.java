package com.example.practice.DesignPattern.CommandPattern.CalculatorExample;

public class SubtractCommand implements Command {

  private CalculatorReceiver calculatorReceiver;
  private int number;

  public SubtractCommand(CalculatorReceiver calculatorReceiver, int number) {
    this.calculatorReceiver = calculatorReceiver;
    this.number = number;
  }

  @Override
  public void execute() {
    calculatorReceiver.subtract(number);
  }

  @Override
  public void undo() {
    calculatorReceiver.add(number);
  }
}
