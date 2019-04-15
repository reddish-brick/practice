package com.example.practice.OODesign.ocp.version2;

public class Client {

  public static void main(String[] args) {
    Teacher teacher1 = new Teacher();
    teacher1.printGrade();

    Teacher teacher2 = new LevelTeacher();
    teacher2.printGrade();
  }
}
