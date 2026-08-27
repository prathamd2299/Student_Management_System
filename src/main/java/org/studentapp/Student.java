package org.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateStudentId(studentId)){
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<>();
        }
    }

    public void enrollCourse(String course) {
        if(validateCourseName(course)) {
        if(!courses.contains(course)) {
            courses.add(course);
            System.out.println("Student is enrolled to " + course + " successfully!!");
        } else {
            System.err.println("Student is already enrolled in the course " + course);
        }
        }
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
        System.out.println("==================== ====================");
    }

    public boolean validateName(String name) {
        /*
        | Symbol      | Meaning                                          |
        | ----------- | ------------------------------------------------ |
        | `^`         | Start of the string                              |
        | `\\s`         | Whitespaces allowed                              |
        | `[A-Za-z ]` | Uppercase letters, lowercase letters, and spaces |
        | `+`         | One or more characters                           |
        | `$`         | End of the string                                |
         */
        String nameRegx = "^[A-Za-z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegx);

        Matcher nameMatcher = namePattern.matcher(name);

        if(nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Name!! Please enter alphabets only");
            return false;
        }
    }

    public boolean validateStudentId(String studentId) {
        String studentIdRegx = "^S-\\d+$";

        Pattern studentIdPattern = Pattern.compile(studentIdRegx);

        Matcher studentIdMatcher = studentIdPattern.matcher(studentId);

        if(studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid StudentId!! Use formats...e.g...S-123");
            return false;
        }
    }
    public boolean validateCourseName(String course) {
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA")
        || course.equalsIgnoreCase("DevOps")) {
            return true;
        } else{
            System.err.println("Invalid course name!! Please select courses from the list [Java, DSA, DevOps]");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
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
