package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        if(validateAge(age)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<>();
        }
    }

    public void enrollCourse(String course) {
        courses.add(course);
        System.out.println("Student is enrolled to " + course + " successfully!!");
    }

    public boolean validateAge(int age) {
        if (age >= 19 && age <=35) {
            return true;
        } else {
            System.err.println("Invalid age! Student age must be between 19 and 35!");
            return false;
        }
    }

    public void printStudentInfo() {
        System.out.println("==================== Student Data ====================");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Id: " + studentId);
        System.out.println("List of enrolled courses: " + courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }
}
