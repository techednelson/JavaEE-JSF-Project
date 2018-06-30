package dao;

import model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsDB {
    public static List<Student> students;

    static {
        Student student;
        students = new ArrayList<>();

        student = new Student(1, "Snake", "John", "Smith",
                              new Date(), "USA", "New York",
                              "apple 4", "12345", "012-345-6789",
                              "snake@gmail.com", true);
        students.add(student);
        student = new Student(2, "Cowboy", "George", "Lopez",
                             new Date(), "Greece", "Athens",
                            "apple 4", "12345", "012-345-6789",
                            "cowboy@gmail.com", true);
        students.add(student);
        student = new Student(3, "Batman", "Luis", "Williams",
                             new Date(), "England", "Liverpool",
                            "apple 4", "12345", "012-345-6789",
                            "batman@gmail.com", true);
        students.add(student);
        student = new Student(4, "Hulk", "Miguel", "Woods",
                             new Date(), "Spain", "Sevilla",
                            "apple 4", "12345", "012-345-6789",
                            "hulk@gmail.com", true);
        students.add(student);
        student = new Student(5, "Prime", "Jeniffer", "Fierro",
                             new Date(), "Mexico", "Guadalajara",
                            "apple 4", "12345", "012-345-6789",
                            "prime@gmail.com", true);
        students.add(student);
    }
}
