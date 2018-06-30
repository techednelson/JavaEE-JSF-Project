package services;

import dao.StudentDao;
import model.Student;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDao studentDao;

    @Override
    public void registerStudent(Student student) { studentDao.persist(student); }

    @Override
    public List<Student> getAllStudents() { return studentDao.findAll(); }

    @Override
    public Student getStudent(Student student) { return studentDao.find(student); }

    @Override
    public void updateStudent(Student student) { studentDao.merge(student); }

    @Override
    public void deleteStudent(Student student) { studentDao.remove(student); }

    @Override
    public boolean lookForDuplicate(Student student) { return studentDao.findDuplicate(student) != null; }

}
