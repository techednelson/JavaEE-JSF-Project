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

    private Customer customerToAdd;
    private Customer customerToUpdate;
    private List<Customer> customers;
    private Map<String, Map<String, String>> data = new HashMap<>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;
    private Integer value = 5;

    @PostConstruct
    public void init() {
        customerToAdd = new Customer();
        customers = new ArrayList<>();

        customerToAdd = new Customer(1, "Snake", "John", "Smith", new Date(), "USA", "New York", "apple 4", "12345", "0123456789", "snake@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(2, "Cowboy", "George", "Lopez", new Date(), "Greece", "Athens", "apple 4", "12345", "0123456789", "cowboy@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(3, "Batman", "Luis", "Williams", new Date(), "England", "Liverpool", "apple 4", "12345", "0123456789", "batman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(4, "Hulk", "Miguel", "Woods", new Date(), "Spain", "Sevilla", "apple 4", "12345", "0123456789", "hulk@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(5, "Prime", "Angel", "Fierro", new Date(), "Mexico", "Guadalajara", "apple 4", "12345", "0123456789", "prime@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(6, "Ironman", "Oscar", "Johnson", new Date(), "USA", "Chicago", "apple 4", "12345", "0123456789", "ironman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(7, "Superman", "Charles", "Jones", new Date(), "Greece", "Ioannina", "apple 4", "12345", "0123456789", "superman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(8, "Torn", "Alicia", "Brown", new Date(), "England", "Leeds", "apple 4", "12345", "0123456789", "torn@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(9, "Robin", "Helen", "Davis", new Date(), "Spain", "Madrid", "apple 4", "12345", "0123456789", "robin@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(10, "Ant-man", "Laura", "Miler", new Date(), "Mexico", "Monterrey", "apple 4", "12345", "0123456789", "antman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(11, "Aquaman", "Gloria", "Wilson", new Date(), "USA", "Denver", "apple 4", "12345", "0123456789", "aquaman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(12, "Asterix", "Debby", "Mandela", new Date(), "Greece", "Thessaloniki", "apple 4", "12345", "0123456789", "asterix@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(13, "Daredevil", "Gael", "Jimenez", new Date(), "England", "Manchester", "apple 4", "12345", "0123456789", "daredevil@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(14, "Elektra", "Pedro", "Young", new Date(), "Spain", "Barcelona", "apple 4", "12345", "0123456789", "elektra@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(15, "Hellboy", "Mauricio", "Hernandez", new Date(), "Mexico", "Mexico City", "apple 4", "12345", "0123456789", "hellboy@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(16, "Wolverine", "Homer", "King", new Date(), "USA", "San Francisco", "apple 4", "12345", "0123456789", "wolverine@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(17, "x-men", "Beyonce", "Green", new Date(), "Greece", "Kalamata", "apple 4", "12345", "0123456789", "xmen@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(18, "Wonderwoman", "Issac", "Perez", new Date(), "England", "London", "apple 4", "12345", "0123456789", "wonderwoman@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(19, "Badgirl", "Harry", "Phillips", new Date(), "Spain", "Valencia", "apple 4", "12345", "0123456789", "badgirl@gmail.com", true);
        customers.add(customerToAdd);
        customerToAdd = new Customer(20, "Prime", "Edgar", "Parker", new Date(), "Mexico", "Puebla", "apple 4", "12345", "0123456789", "prime@gmail.com", true);
        customers.add(customerToAdd);

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

        customerToAdd = new Customer();
    }

    public Customer getCustomerToAdd() {
        return customerToAdd;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        this.customerToAdd.setCountry(country);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        this.customerToAdd.setCity(city);
    }

    public Customer getCustomerToUpdate() { return customerToUpdate; }

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
        this.customerToAdd.setID(value);
    }

    public void createNewCustomer() {
        createSerialNumber();
        if (customers.contains(customerToAdd)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Duplicated", "This customer has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.customerToAdd = null;
        } else {
            customers.add(customerToAdd);
            this.customerToAdd = null;
            this.country = null;
            this.city = null;
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Submit Confirmation", "The customer was registered successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        customerToAdd = new Customer();
    }

    public String searchCustomer(Customer customer) {
        this.customerToUpdate = customer;
        return "update_customer?faces-redirect=true";
    }

    public void updateStudent() {
        for(Customer customer: customers) {
            if(this.customerToUpdate.getID().equals(customer.getID())) {
                customers.remove(customer);
                customers.add(customerToUpdate);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Update Conformation", "The customer record was updated successfully");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        customerToUpdate = null;
    }


}


