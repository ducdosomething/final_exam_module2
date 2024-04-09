package studentManager;

import model.Gender;
import model.Student;

import java.util.*;

public class StudentManager {
    public static void addStudent(Scanner scanner, List<Student> students) {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.println("Enter gender:");
        Gender gender = Gender.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter student address: ");
        String address = scanner.next();
        System.out.println("Enter gpa:");
        Double gpa = scanner.nextDouble();

        Student student = new Student(id, name, age, gender, address, gpa);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public static void viewAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void viewStudentsInGroup(List<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        int groupSize = 5;
        int totalStudents = students.size();
        int currentIndex = 0;

        while (true) {
            System.out.println("Press Enter to view the next 5 students (or exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Returning to main menu...");
                break;
            }

            for (int i = 0; i < groupSize && currentIndex < totalStudents; i++) {
                Student student = students.get(currentIndex);
                System.out.println(student);
                currentIndex++;
            }

            if (currentIndex >= totalStudents) {
                System.out.println("End of student list. Returning to main menu...");
                break;
            }
        }
    }

    public static void updateStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to update: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();

                student.setName(newName);
                student.setAge(newAge);
                student.setAddress(newAddress);

                System.out.println("Student information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to delete: ");
        String name = scanner.nextLine();
        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void searchStudentByName(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void sortStudentsByAgeDescending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getAge(), s1.getAge()); // Descending order
            }
        });

        System.out.println("Students sorted by age (descending) successfully.");
    }

    public static void sortStudentsByAgeAscending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge()); // Ascending order
            }
        });

        System.out.println("Students sorted by age (ascending) successfully.");
    }
}

