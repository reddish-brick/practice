package com.example.practice.DesignPattern.ObserverPattern.pullPattern;

/**
 * 真正的读者，为了简单就描述一下姓名
 */
public class ReaderObserver implements Observer {

  /**
   * 读者的姓名
   */
  private String name;

  public ReaderObserver(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void update(Subject subject) {
    //这是采用拉的方式
    System.out.println(name + "收到报纸了，阅读先。内容是===" + ((NewspaperSubject) subject).getContent());
  }
}
