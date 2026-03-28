package StudentManagementSystem;

public class Main {

    public static void main(String[] args) {

        // Create sample students
        Student student1 = new Student("Alice", 20, "S12345");
        student1.enrollCourse("Mathematics");
        student1.enrollCourse("Computer Science");
        student1.printStudentInfo();

        Student student2 = new Student("Bob", 22, "S67890");
        student2.enrollCourse("Physics");
        student2.enrollCourse("Chemistry");
        student2.printStudentInfo();

        Student student3 = new Student("Charlie", 19, "S54321");
        student3.enrollCourse("Biology");   
        student3.enrollCourse("History");
        student3.printStudentInfo();

        // Add students to the list
        Student.students.add(student1);
        Student.students.add(student2); 
        Student.students.add(student3);

        // Find student by ID
        try {
            Student.findStudentByID("S123e45");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Add new students using user input
        Student.addStudents(2);                 // Add students
        Student.sortStudentsUsingComparator();  // Sort using comparator
        Student.printAllStudents();             // Print sorted list

    }
}
