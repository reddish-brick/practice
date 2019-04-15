package com.example.practice.OODesign.ocp.version2;

public class LevelTeacher extends Teacher {

  @Override
  public void printGrade() {
    Teacher.students.stream().forEach(student -> {
      String level = null;
      int grade = Integer.valueOf(student.getGrade());
      if (grade >= 90) {
        level = "优秀";
      } else if (grade >= 80 && grade < 90) {
        level = "良好";
      } else if (grade >= 70 && grade < 80) {
        level = "一般";
      } else if (grade >= 60 && grade < 70) {
        level = "及格";
      } else if (grade < 60) {
        level = "不及格";
      }
      System.out.println(String.format("name: %s level: %s", student.getName(), level));
    });
  }
}
