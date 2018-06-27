package controller;

import model.Student;
import services.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
public class StudentsController implements Serializable {

    @EJB
    private StudentService studentService;

    private List<Student> students;
    private Student studentSelected;
    private Student studentToUpdate;

    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
        studentSelected = new Student();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentSelected() { return studentSelected; }

    public void setStudentSelected(Student studentSelectedFromTable) {
        studentSelected = studentSelectedFromTable;
    }

    public Student getStudentToUpdate() { return studentToUpdate; }

    public String editStudentRecord() {
        searchStudentToUpdate();
        return "update_student?faces-redirect=true";
    }

    private void searchStudentToUpdate() {
        studentToUpdate = studentService.getStudent(studentSelected);
    }

    public void updateStudent() {
        studentService.updateStudent(studentToUpdate);
    }

    public void deleteStudent() {
        studentService.deleteStudent(studentSelected);
        studentSelected = null;
        init();  //List update
    }

}
