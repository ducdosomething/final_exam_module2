package storage;

import model.Gender;
import model.Student;

import java.io.*;
import java.util.List;

public class ReadWriteFile {
    private static final String FILENAME = "students.csv";
    public static void saveStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," +
                                student.getGender() + "," + student.getAddress() + "," + student.getGpa());
                writer.newLine();
            }
            System.out.println("Students saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    public static void loadStudentsFromFile(List<Student> students) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    Gender gender = Gender.valueOf(parts[3]);
                    String address = parts[4];
                    Double gpa = Double.parseDouble(parts[5]);
                    students.add(new Student(id, name, age, gender, address, gpa));
                }
            }
            System.out.println("Students loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }
}
