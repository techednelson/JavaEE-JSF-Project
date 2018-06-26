package controller;

import model.Student;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import services.StudentService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class StudentsController implements Serializable {

    @Inject
    private StudentService studentService;

    private List<Student> students;

    private Student studentSelected;

    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
        studentSelected = new Student();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentSelected() { return studentSelected; }

    public void setStudentSelected(Student studentSelected) { this.studentSelected = studentSelected; }

    public void updateStudent() {
        this.studentSelected = new Student();
    }

    public void deleteStudent() {
        studentService.deleteStudent(this.studentSelected);
        this.studentSelected = null;
        //List update
        this.init();
    }

    public StudentService getStudentService() { return studentService; }

    public void setStudentService(StudentService studentService) { this.studentService = studentService; }

}
