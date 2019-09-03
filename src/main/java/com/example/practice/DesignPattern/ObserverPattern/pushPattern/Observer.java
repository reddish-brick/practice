package com.example.practice.DesignPattern.ObserverPattern.pushPattern;

/**
 * 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {

  /**
   * 被通知的方法，直接把报纸的内容推送过来
   *
   * @param content 报纸的内容
   */
  void update(String content);
}
