package view;

import model.Student;
import services.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;


@Named
@FacesConfig(version = JSF_2_3)
@SessionScoped
public class StudentsController implements Serializable {

    @EJB
    private StudentService studentService;

    private List<Student> students;
    private Student studentSelected;
    private Student studentToUpdate;
    private String currentPageLanguage;

    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
        studentSelected = new Student();
        currentPageLanguage = "english";
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentSelected() { return studentSelected; }

    public void setStudentSelected(Student studentSelectedFromTable) {
        studentSelected = studentSelectedFromTable;
    }

    public Student getStudentToUpdate() { return studentToUpdate; }

    public String changeToSpanishFromStudentsForm() {
        currentPageLanguage = "spanish";
        return "students_spanish?faces-redirect=true";
    }

    public String changeToEnglishFromStudentsForm() {
        currentPageLanguage = "english";
        return "students?faces-redirect=true";
    }

    private void searchStudentToUpdate() {
        studentToUpdate = studentService.getStudent(studentSelected);
    }

    public String editStudentRecord() {
        searchStudentToUpdate();
        return currentPageLanguage.equals("english") ? "update_student?faces-redirect=true" : "update_student_spanish?faces-redirect=true";
    }

    public void updateStudent() {

        try {
            studentService.updateStudent(studentToUpdate);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Update was successful! ",
                            " Enjoy your Spanish Lessons"
                    ));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage (
                            FacesMessage.SEVERITY_FATAL,
                            "Update Error! ",
                            " There was an error with the update, try again!"
                    ));
        }
    }

    public void deleteStudent() {
        studentService.deleteStudent(studentSelected);
        studentSelected = null;
        init();  //List update
    }

}
