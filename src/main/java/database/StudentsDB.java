package database;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsDB {
    public static List<Student> students;

    static {
        Student student;
        students = new ArrayList<>();

        student = new Student("Snake", "John", "Smith");
        students.add(student);
        student = new Student("Cowboy", "George", "Lopez");
        students.add(student);
        student = new Student("Batman", "Luis", "Williams");
        students.add(student);
        student = new Student("Hulk", "Miguel", "Woods");
        students.add(student);
        student = new Student("Prime", "Jeniffer", "Fierro");
        students.add(student);
    }
}
