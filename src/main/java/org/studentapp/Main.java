package org.studentapp;

import com.studentapp.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("********************* Student Management System *********************");
        System.out.println("********************* Welcome *********************");

        Student s1 = new Student("Prathamesh", 260, "S1");
        System.out.println(s1);
        Student s2 = new Student("Akshay", 22, "S2");
        System.out.println(s2);
        Student s3 = new Student("Girish", 30, "S3");
        System.out.println(s3);

        s1.enrollCourse("Java");
        s2.enrollCourse("Python");
        s3.enrollCourse("Javascript");

        s1.printStudentInfo();
        s2.printStudentInfo();
        s3.printStudentInfo();
    }
}