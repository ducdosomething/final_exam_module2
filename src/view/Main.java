package view;

import model.Student;
import storage.ReadWriteFile;
import studentManager.StudentManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("----------------------- STUDENTS MANAGEMENT -----------------------");
            System.out.println("1. View all students");
            System.out.println("2. View group students(5)");
            System.out.println("3. Add student");
            System.out.println("4. Update student info");
            System.out.println("5. Delete student");
            System.out.println("6. Sort students by age (Ascending)");
            System.out.println("7. Sort students by age (Descending)");
            System.out.println("8. Load students from file");
            System.out.println("9. Save students to file");
            //System.out.println("7. Search Student by Name");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    StudentManager.viewAllStudents(students);
                    break;
                case 2:
                    StudentManager.viewStudentsInGroup(students, scanner);
                    break;
                case 3:
                    StudentManager.addStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 4:
                    StudentManager.updateStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 5:
                    StudentManager.deleteStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 6:
                    StudentManager.sortStudentsByAgeAscending(students);
                    break;
                case 7:
                    StudentManager.sortStudentsByAgeDescending(students);
                    break;
                case 8:
                    ReadWriteFile.loadStudentsFromFile(students);
                    break;
                case 9:
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
//                case 7:
//                    StudentManager.searchStudentByName(scanner, students);
//                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

