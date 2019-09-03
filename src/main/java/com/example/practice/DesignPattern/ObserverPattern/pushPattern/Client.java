package com.example.practice.DesignPattern.ObserverPattern.pushPattern;

public class Client {

  public static void main(String[] args) {
    //创建一个报纸，作为被观察者
    NewspaperSubject subject = new NewspaperSubject();
    //创建阅读者，也就是观察者
    ReaderObserver reader1 = new ReaderObserver("张三");

    ReaderObserver reader2 = new ReaderObserver("李四");

    ReaderObserver reader3 = new ReaderObserver("王五");

    //注册阅读者
    subject.addReader(reader1);
    subject.addReader(reader2);
    subject.addReader(reader3);

    //要出报纸啦
    subject.setContent("本期内容是观察者模式");
  }
}
