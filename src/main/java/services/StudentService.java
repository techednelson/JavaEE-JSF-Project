package services;

import model.Student;

import java.util.List;

public interface StudentService {

    void registerStudent(Student student);

    List<Student> getAllStudents();

    Student getStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
