package controller;

import model.Student;
import services.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    public void showAboutMessage() {
        addMessage("Powered by Prime Faces", "This is Java full stack application example developed following the Multilayer Architecture. With JSF Prime Faces framework in the frontend");
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
