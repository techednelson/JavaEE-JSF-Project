package view;

import model.Student;
import services.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Named
@SessionScoped
public class NewStudentController implements Serializable {

    @EJB
    private StudentService newStudentService;

    private Map<String,Map<String,String>> data = new HashMap<>();
    private String country;
    private String city;
    private Map<String,String> countries;
    private Map<String,String> cities;
    private Student newStudent;

    private Integer value = 5;

    @PostConstruct
    public void init() {
        newStudent= new Student();

        countries  = new HashMap<>();
        countries.put("Greece", "Greece");
        countries.put("England", "England");
        countries.put("Mexico", "Mexico");
        countries.put("Spain", "Spain");
        countries.put("USA", "USA");

        Map<String,String> map = new HashMap<>();
        map.put("Thessaloniki", "Thessaloniki");
        map.put("Patra", "Patra");
        map.put("Ioannina", "Ioannina");
        map.put("Kalamata", "Kalamata");
        map.put("Athens", "Athens");
        data.put("Greece", map);

        map = new HashMap<>();
        map.put("London", "London");
        map.put("Leeds", "Leeds");
        map.put("Manchester", "Manchester");
        map.put("Liverpool", "Liverpool");
        map.put("New Castle", "New Castle");
        data.put("England", map);

        map = new HashMap<>();
        map.put("Mexico City", "Mexico City");
        map.put("Monterrey", "Monterrey");
        map.put("Guadalajara", "Guadalajara");
        map.put("Leon", "Leon");
        map.put("Puebla", "Puebla");
        data.put("Mexico", map);

        map = new HashMap<>();
        map.put("Madrid", "Madrid");
        map.put("Sevilla", "Sevilla");
        map.put("Barcelona", "Barcelona");
        map.put("Malaga", "Malaga");
        map.put("Valencia", "Valencia");
        data.put("Spain", map);

        map = new HashMap<>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        map.put("Los Angeles", "Los Angeles");
        map.put("Chicago", "Chicago");
        data.put("USA", map);
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(Student newStudent) {
        this.newStudent = newStudent;
    }

    public StudentService getNewStudentService() { return newStudentService; }

    public void setNewStudentService(StudentService newStudentService) { this.newStudentService = newStudentService; }

    public Map<String, Map<String, String>> getData() { return data; }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
        this.newStudent.setCountry(country);
    }

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = city;
        this.newStudent.setCity(city);
    }

    public Map<String, String> getCountries() { return countries; }

    public Map<String, String> getCities() { return cities; }

    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<>();
    }

    private void createSerialNumber() {
        value++;
        newStudent.setID(value);
    }

    private boolean isStudentAlreadyInDB() {
        return newStudentService.lookForDuplicate(newStudent);
    }

    public void addNewStudent() {
        if(!isStudentAlreadyInDB()) {
            try {
                createSerialNumber();
                newStudentService.registerStudent(newStudent);
                newStudent = null;
                country =  "";
                city= "";
                init();
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage (
                                FacesMessage.SEVERITY_INFO,
                                "Registration was successful! ",
                                " Welcome to LearnSpanish Lessons"
                        ));
            } catch (Exception e) {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage (
                                FacesMessage.SEVERITY_FATAL,
                                "Registration Error! ",
                                " There was an error with your Registration, try again!"
                        ));
            }
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage (
                            FacesMessage.SEVERITY_FATAL,
                            "Registration Error! ",
                            " The username already exist in our system, try with different username!"
                    ));
        }
    }

}
