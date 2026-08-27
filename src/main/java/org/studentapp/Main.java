package org.studentapp;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Student> studentList;
    private static Scanner input;

    public static void main(String[] args) {
        System.out.println("********************* Student Management System *********************");

        studentList = new ArrayList<>();
        input = new Scanner(System.in);

        while (true) {
            System.out.println("********************* Welcome *********************");
            System.out.println("Select an option....");
            System.out.println("1. Register Student");
            System.out.println("2. Find Student with studentId");
            System.out.println("3. List all Students information");
            System.out.println("4. List student information in sorted order");
            System.out.println("5. Exit");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    enrollStudent(input);
                    break;

                case 2:
                    findStudentById(input);
                    break;

                case 3:
                    printAllStudentData();
                    break;

                case 4:
                    sortByName();
                    break;

                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Invalid option selected! Enter between 1 to 5");
            }
        }
    }

    private static void printAllStudentData() {
        if (!studentList.isEmpty()) {
            System.out.println("********************** PRINTING all students data *********************");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
        } else {
            System.err.println("No students record found! Student list is empty!");
        }
    }

    private static void exit() {
        System.out.println("Goodbye!!");
        System.exit(0);
    }

    public static Student findStudentById(String studentId) {
        Student result = null;

        try {
            result = studentList.stream()
                    .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found!!!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found.");
        }

        return result;
    }

    public static void findStudentById(Scanner input) {
        System.out.println("Enter Student Id: ");
        String studentId = input.next();
        Student studentFound = null;

        try {
            studentFound = studentList.stream()
                    .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found!!!"));

            studentFound.printStudentInfo();
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found.");
        }

        System.out.println("Student with ID " + studentId + " found!");
    }

    private static void sortByName() {
//        Comparator<Student> studentComparatorByName = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };

        Comparator<Student> studentComparatorByName = (o1, o2) -> o1.getName().compareTo(o2.getName());

        Collections.sort(studentList, studentComparatorByName);
        System.out.println(studentList);
    }

    private static void enrollStudent(Scanner input) {
        System.out.println("Enter Student Name: ");
        String studentName = input.next();
        System.out.println("You have entered the name: " + studentName);
        System.out.println("Enter Student Age: ");
        int studentAge = input.nextInt();
        System.out.println("You have entered the age: " + studentAge);
        System.out.println("Enter Student Id: ");
        String studentId = input.next();
        System.out.println("You have entered the studentId: " + studentId);

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);

        while (true) {
            System.out.println("Enter the course to be enrolled!!...Type done to Exit");
            String courseName = input.next();
            System.out.println("You have entered the course: " + courseName);

            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
        }

        System.out.println("Student enrolled successfully into the LMS");
        newStudent.printStudentInfo();
    }
}