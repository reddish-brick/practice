package com.example.practice.DesignPattern.CommandPattern.CalculatorExample;

import java.util.ArrayList;
import java.util.List;

public class CalculatorInvoker {

  /**
   * 命令的操作的历史记录，在撤销时候用
   */
  private List<Command> commands = new ArrayList<>();

  private Command addCommand;

  public void setAddCommand(Command addCommand) {
    this.addCommand = addCommand;
  }

  private Command subtractCommand;

  public void setSubtractCommand(Command subtractCommand) {
    this.subtractCommand = subtractCommand;
  }

  void addOperation() {
    this.addCommand.execute();
    this.commands.add(addCommand);
  }

  void subtractOperation() {
    this.subtractCommand.execute();
    this.commands.add(subtractCommand);
  }

  void undo() {
    if (this.commands.size() > 0) {
      //取出最后一个命令来撤销
      Command cmd = this.commands.get(this.commands.size() - 1);
      cmd.undo();
      //然后把最后一个命令删除掉，
      this.commands.remove(cmd);
    } else {
      System.out.println("很抱歉，没有可撤销的命令");
    }
  }

  public void redo(){
    if(this.commands.size()>0){
      //取出最后一个命令来重做
      Command cmd = this.commands.get(commands.size()-1);
      cmd.execute();
      //把这个命令记录到可撤销的历史记录里面
      this.commands.add(cmd);
      //然后把最后一个命令删除掉
      this.commands.remove(cmd);
    }else{
      System.out.println("很抱歉，没有可恢复的命令");
    }
  }
}
