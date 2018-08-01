package controllers;

import database.Database;
import model.Customer;
import validation.ServerValidator;

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
    private Map<String, Map<String, String>> data = new HashMap<>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;
    private boolean isUpdate;

    @Inject
    private Customer customer;

    @Inject
    private ServerValidator validator;

    @PostConstruct
    public void init() {
        customers = Database.getCustomers();
        countries = Database.getCountries();
        data = Database.getCities();
    }

    public List<Customer> getCustomers() { return customers; }

    public Customer getCustomer() {
        return customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (country != null && !country.equals("")) {
            cities = data.get(country);
        } else {
            cities = new HashMap<>();
        }
    }

    private void createID() {
        List<Integer> idList = new ArrayList<>();
        for(Customer customer : customers) {
            idList.add(customer.getID());
        }
        Integer value = Collections.max(idList) + 1;
        this.customer.setID(value);
    }

    public void serviceRequest(Customer customer) {
        if(isUpdate) {
            updateCustomer(this.customer);
        } else {
            createNewCustomer(customer);
        }
    }

    public void selectCRUDMethod(Integer id) {
        if(id  == null) {
            isUpdate = false;
        } else {
            isUpdate = true;
            for (Customer item : customers) {
                if(id.equals(item.getID())) {
                    this.customer = item;
                    this.country = item.getCountry();
                    this.city = item.getCity();
                }
            }
        }
    }

    private void createNewCustomer(Customer customer) {
        if(validator.validateCustomer(customer)) {
            if (customers.contains(customer) && !isUpdate) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Duplicated", "This customer has already been added");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                createID();
                Database.addCustomer(customer);
                customers = Database.getCustomers();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Submit Confirmation", "The customer was registered successfully");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data provided, please try again");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    private void updateCustomer(Customer customer) {
        if(validator.validateCustomer(customer) && isUpdate) {
            for(Customer item: customers) {
                if(customer.getID().equals(item.getID())) {
                    customers.remove(item);
                    customers.add(customer);
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Update Conformation", "The customer record was updated successfully");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    return;
                }
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data provided, please try again");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Validation Error", "There was an error with data entered, please try again");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void deleteCustomer(Customer customer) {
        if(customer != null) {
            Database.removeCustomer(customer);
            customers = Database.getCustomers();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Delete Confirmation", "The customer was removed successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Delete failed", "There was a problem removing customer");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}


