package com.example.practice.DesignPattern.CommandPattern.MainBoardExample;

/**
 * 机箱对象，本身有按钮，持有按钮对应的命令对象,在Command模式中充当Invoker
 */
public class Box {

  private Command openCommand;

  public void setOpenCommand(Command command) {
    this.openCommand = command;
  }

  public void openButtonPressed() {
    //按下按钮，执行命令
    openCommand.execute();
  }

  /**
   * 重启机器命令对象
   */
  private Command resetCommand;

  /**
   * 设置重启机器命令对象
   */
  public void setResetCommand(Command command) {
    this.resetCommand = command;
  }

  /**
   * 提供给客户使用，接收并相应用户请求，相当于重启按钮被按下触发的方法
   */
  public void resetButtonPressed() {
    //按下按钮，执行命令
    resetCommand.execute();
  }
}  