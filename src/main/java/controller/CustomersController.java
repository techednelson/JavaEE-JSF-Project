package controller;

import model.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@Named
@FacesConfig(version = JSF_2_3)
@SessionScoped
public class CustomersController implements Serializable {

    private Customer customer;
    private List<Customer> customers;
    private Map<String, Map<String, String>> data = new HashMap<>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;
    private Integer value = 5;

    @PostConstruct
    public void init() {
        customer = new Customer();
        customers = new ArrayList<>();

        customer = new Customer(1, "Snake", "John", "Smith", new Date(), "USA", "New York", "apple 4", "12345", "012-345-6789", "snake@gmail.com", true);
        customers.add(customer);
        customer = new Customer(2, "Cowboy", "George", "Lopez", new Date(), "Greece", "Athens", "apple 4", "12345", "012-345-6789", "cowboy@gmail.com", true);
        customers.add(customer);
        customer = new Customer(3, "Batman", "Luis", "Williams", new Date(), "England", "Liverpool", "apple 4", "12345", "012-345-6789", "batman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(4, "Hulk", "Miguel", "Woods", new Date(), "Spain", "Sevilla", "apple 4", "12345", "012-345-6789", "hulk@gmail.com", true);
        customers.add(customer);
        customer = new Customer(5, "Prime", "Jeniffer", "Fierro", new Date(), "Mexico", "Guadalajara", "apple 4", "12345", "012-345-6789", "prime@gmail.com", true);
        customers.add(customer);

        countries = new HashMap<>();
        countries.put("Greece", "Greece");
        countries.put("England", "England");
        countries.put("Mexico", "Mexico");
        countries.put("Spain", "Spain");
        countries.put("USA", "USA");

        Map<String, String> map = new HashMap<>();
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

        customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        this.customer.setCountry(country);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        this.customer.setCity(city);
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void onCountryChange() {
        if (country != null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<>();
    }

    private void createSerialNumber() {
        value++;
        this.customer.setID(value);
    }

    public void createNewCustomer() {
        createSerialNumber();
        if (customers.contains(customer)) {
            FacesMessage msg = new FacesMessage("Duplicated", "This customer has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            customers.add(customer);
            customer = new Customer();
        }
        customer = new Customer();
    }

    public void updateStudent() {

        try {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Update was successful! ",
                            " Enjoy your Spanish Lessons"
                    ));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_FATAL,
                            "Update Error! ",
                            " There was an error with the update, try again!"
                    ));
        }
    }


}


