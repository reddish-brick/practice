package com.example.practice.DesignPattern.BuilderPattern;

public class Client {

  public static void main(String[] args) {
    Director director = new Director();
    Builder commonRoleBuilder = new CommonRoleBuilder();
    director.construct(commonRoleBuilder);
    Role commonRole = commonRoleBuilder.getResult();

    Builder superRoleBuilder = new SuperRoleBuilder();
    director.construct(superRoleBuilder);
    Role superRole = superRoleBuilder.getResult();

    System.out.println(commonRole);
    System.out.println(superRole);
  }
}