package com.example.practice;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
    List<User> users = Arrays.asList(
        User.builder().age("123").name("tom").build(),
        User.builder().age("12").name("tom").build(),
        User.builder().age("12").name("toy").build());
    System.out.println(users.stream().filter(user -> Collections.frequency(users, user) >1).collect(Collectors.toSet()));
  }

  @Builder
  @Data
  @EqualsAndHashCode(of = {"name"})
  static class User {
    private String name;
    private String age;
  }
}
