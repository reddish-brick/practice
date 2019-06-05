package com.example.practice.DesignPattern.BuilderPattern;

public abstract class Builder {

  public abstract void buildHead();

  public abstract void buildFace();

  public abstract void buildBody();

  public abstract void buildHp();

  public abstract void buildSp();

  public abstract void buildMp();

  abstract Role getResult();
}