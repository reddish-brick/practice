package com.example.practice.DesignPattern.ObserverPattern.pullPattern;

public class NewspaperSubject extends Subject {

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
    //状态发生了改变，通知各个观察者
    this.notifyObservers();
  }
}
