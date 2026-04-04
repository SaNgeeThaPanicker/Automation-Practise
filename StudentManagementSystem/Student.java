package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    // Instance variables to store student details
    private String name;
    private int age;
    private String studentID;
    private ArrayList<String> courses;

    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private static int uniqueIDCounter = 10000;

    // Constructor to initialize student details
    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", studentID='" + studentID + "', courses=" + courses + "}";
    }

    public String getStudentID() {
        return studentID;
    }

    // Enroll in a course
    public void enrollCourse(String course) {
        courses.add(course);
    }

    // Print student information
    public void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentID);
        System.out.println("Courses: " + courses);
        System.out.println("----------------------");
    }

    // Add new students using user input
    public static void addStudents(int numberOfStudents) {
        for (int i = 0; i < numberOfStudents; i++) {

            // Local variables to store user input for each student
            System.out.println("Enter student name:");
            String name = scanner.nextLine(); 

            System.out.println("Enter student age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String studentID = "S" + uniqueIDCounter++;

            // create new object first
            Student newStudent = new Student(name, age, studentID);

            System.out.println("Enter first course:");
            newStudent.enrollCourse(scanner.nextLine());

            System.out.println("Enter second course:");
            newStudent.enrollCourse(scanner.nextLine());

            students.add(newStudent);
        }
    }

    // Search for a student by ID and print their info
    public static void findStudentByID(String id) {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                student.printStudentInfo();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // ✔ Collections.sort() → performs sorting
    // ✔ Comparator → defines rules
    // ✔ compare() → decides order
    // ✔ compareTo() → compares strings

    // Sort students by name in alphabetical order
    public static void sortStudentsUsingComparator() {
    java.util.Collections.sort(students, new java.util.Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    });
}

    // For each student in the list, print their info
    public static void printAllStudents() {
    for (Student student : students) {
        student.printStudentInfo();
    }
}
}