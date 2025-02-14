package pravtice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(firstName, lastName, age, course);
                    StudentManager.addStudent(student);
                    break;
                case 2:
                    StudentManager.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter First Name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Course: ");
                    course = scanner.nextLine();
                    student = new Student(firstName, lastName, age, course);
                    StudentManager.updateStudent(studentId, student);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    studentId = scanner.nextInt();
                    StudentManager.deleteStudent(studentId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
