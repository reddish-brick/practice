package com.example.practice.GenericProgramming.method;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
    System.out.println(genericMethod(User.class, Customer.class));
    System.out.println(genericMethod(new User(), new Customer()));
    System.out.println(parseArray("{\"username\":\"username\",\"password\":\"password\"}"));
    System.out.println(parseArray("{\"username\":\"username\",\"password\":\"password\"}", User.class));
    System.out.println(parse("{\"username\":\"username\",\"password\":\"password\"}", Customer.class));
  }

  public static <T extends User, R extends Customer> String genericMethod(Class<T> tClass, Class<R> rClass) throws IllegalAccessException, InstantiationException {
    T userInstance = tClass.newInstance();
    R customerInstance = rClass.newInstance();
    return userInstance.getUsername() + "  " + customerInstance.getUsername();
  }

  public static <T extends User, R extends Customer> String genericMethod(T t, R r) {
    return t.getUsername() + "  " + r.getUsername();
  }

  public static User parseArray(String response) throws IOException {
    User user = new ObjectMapper().readValue(response, User.class);
    return user;
  }

  public static <T> T parseArray(String response, Class<T> object) throws IOException {
    T t = new ObjectMapper().readValue(response, object);
    return t;
  }

  public static Customer parse(String response, Class<? extends Customer> object) throws IOException {
    Customer user = new ObjectMapper().readValue(response, object);
    return user;
  }
}
