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
        System.out.println("Enter gender (MALE/FEMALE/OTHER):");
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
        System.out.print("Enter the student ID you want to update (or press Enter to exit):  ");
        String inputId = scanner.nextLine().trim();

        if (inputId.isEmpty()) {
            System.out.println("Exiting update student information...");
            return;
        }

        boolean found = false;
        for (Student student : students) {
            if (String.valueOf(student.getId()).equals(inputId)) {
                System.out.print("Enter new ID: ");
                int newId = scanner.nextInt();
                System.out.print("Enter new name: ");
                String newName = scanner.next();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                System.out.print("Enter new gender (MALE/FEMALE/OTHER): ");
                Gender newGender = Gender.valueOf(scanner.next().toUpperCase());
                System.out.print("Enter new address: ");
                String newAddress = scanner.next();
                System.out.print("Enter new GPA: ");
                double newGpa = scanner.nextDouble();

                student.setId(newId);
                student.setName(newName);
                student.setAge(newAge);
                student.setGender(newGender);
                student.setAddress(newAddress);
                student.setGpa(newGpa);

                System.out.println("Student information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found with the given ID.");
        }
    }

    public static void deleteStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the student ID you want to delete (or press Enter to exit): ");
        String inputIdStr = scanner.nextLine().trim();

        if (inputIdStr.isEmpty()) {
            System.out.println("Exiting delete student information...");
            return;
        }

        int inputId;
        inputId = Integer.parseInt(inputIdStr);
        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == inputId) {
                System.out.print("Are you sure you want to delete this student? (Y/N): ");
                String confirmation = scanner.nextLine().trim().toUpperCase();
                if (confirmation.equals("Y")) {
                    iterator.remove();
                    System.out.println("Student deleted successfully.");
                } else if (confirmation.equals("N")) {
                    System.out.println("Operation cancelled. No changes made.");
                } else {
                    System.out.println("Invalid input! Please enter 'Y' to confirm deletion or 'N' to cancel.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found with the given ID.");
        }
    }

    public static void sortStudentsByGpaDescending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });

        System.out.println("Students sorted by GPA (descending) successfully.");
    }

    public static void sortStudentsByGpaAscending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        });

        System.out.println("Students sorted by GPA (ascending) successfully.");
    }
}

