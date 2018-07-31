package controller;

import database.Database;
import model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@Named
@FacesConfig(version = JSF_2_3)
@ViewScoped
public class CustomerController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Customer> customers;
    private Customer customer;
    private Customer customerToUpdate;
    private Map<String, Map<String, String>> data = new HashMap<>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;
    private Integer value = 20;

    @Inject
    private CustomerValidator customerValidator;

    @PostConstruct
    public void init() {
        Database.createCustomerDB();
        customers = Database.getCustomers();
        countries = Database.getCountries();
        data = Database.getCities();
        customer = new Customer();
    }

    public List<Customer> getCustomers() { return customers; }

    public void setCustomers(List<Customer> customers) { this.customers = customers; }

    public Customer getCustomer() {
        return customer;
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

    private void createID() {
        value++;
        this.customer.setID(value);
    }

    private void reInit() {
        this.customer = null;
        this.country = null;
        this.city = null;
        customers = Database.getCustomers();
        this.customer = new Customer();
    }


    public void createNewCustomer() {
        if(customerValidator.validateCustomer(this.customer)) {
            if (customers.contains(customer)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Duplicated", "This customer has already been added");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                this.customer = null;
            } else {
                createID();
                Database.setCustomer(customer);
                reInit();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Submit Confirmation", "The customer was registered successfully");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data provided, please try again");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String searchCustomer(Customer customer) {
        this.customerToUpdate = customer;
        return "update_customer?faces-redirect=true";
    }

    public void updateCustomer() {
        if(this.customer == null) System.out.println("yes");
        if(customerValidator.validateCustomer(customerToUpdate)) {
            for(Customer customer: customers) {
                if(this.customerToUpdate.getID().equals(customer.getID())) {
                    customers.remove(customer);
                    customers.add(customerToUpdate);
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Update Conformation", "The customer record was updated successfully");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    this.country = null;
                    this.city = null;
                    customerToUpdate = null;
                    return;
                }
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data provided, please try again");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

            customerToUpdate = null;
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data entered, please try again");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }


}


