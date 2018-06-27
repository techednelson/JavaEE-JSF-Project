package dao;

import database.StudentsDB;
import model.Student;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentDaoImpl implements StudentDao {

    @Override
    public void persist(Student student) { StudentsDB.students.add(student); }

    @Override
    public List<Student> findAll() { return StudentsDB.students; }

    @Override
    public Student find(Student student) {
        for (Student studentInDB: StudentsDB.students) {
            if(student.getID().equals(studentInDB.getID())) {
                return studentInDB;
            }
        }
        return null;
    }

    @Override
    public void merge(Student student) {
        for (Student studentInDB: StudentsDB.students) {
            if(student.getID().equals(studentInDB.getID())) {
                StudentsDB.students.remove(studentInDB);
                StudentsDB.students.add(student);
                return;
            }
        }
    }

    @Override
    public void remove(Student student) {
        for (Student studentInDB: StudentsDB.students) {
            if(student.getID().equals(studentInDB.getID())) {
                StudentsDB.students.remove(studentInDB);
            }
        }
    }

}
