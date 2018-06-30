package dao;

import model.Student;

import java.util.List;

public interface StudentDao {

    void persist(Student student);

    List<Student> findAll();

    Student find(Student student);

    void merge(Student student);

    void remove(Student student);

    Student findDuplicate(Student student);
}
