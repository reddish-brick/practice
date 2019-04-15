package com.example.practice.OODesign.ocp.version2;

public class Student {

  private String name;
  private String grade;

  public Student(String name, String grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public String getGrade() {
    return grade;
  }
}
