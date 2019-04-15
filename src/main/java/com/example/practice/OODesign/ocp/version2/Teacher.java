package com.example.practice.OODesign.ocp.version2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Teacher {

  public final static List<Student> students = new ArrayList<>();

  static {
    students.add(new Student("tom", "87"));
    students.add(new Student("tony", "96"));
    students.add(new Student("mary", "78"));
    students.add(new Student("jim", "63"));
  }

  public void printGrade() {
    students.stream()
        .forEach(student -> out.println(String.format("name: %s grade: %s", student.getName(), student.getGrade())));
  }
}
