package model;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Customer implements Serializable {

    private Integer ID;

    @Size(min=3, max=10, message="UserName should not be empty")
    @Pattern(regexp = "^\\b\\pL\\w*(?:-\\pL\\w*)*\\b", message = "username can not have blank spaces")
    private String username;

    @Size(min=3, max=10,  message="FirstName should not be empty")
    @Pattern(regexp = "^\\b\\pL+(?:-\\pL+)*\\b", message = "FirstName can not have blank spaces or numbers")
    private String firstname;

    @Size(min=3, max=10, message="LastName should not be empty")
    @Pattern(regexp = "^\\b\\pL+(?:-\\pL+)*\\b", message = "LastName can not have blank spaces or numbers")
    private String lastname;

    @Past
    private Date birthDate;

    private String country;

    private String city;

    @Size(min=10,max=35)
    private String street;

    @Size(min=5,max=7)
    @Pattern(regexp = "^\\d+", message = "Zip Code can not have letters")
    private String zipCode;

    @Size(min=10,max=10)
    @Pattern(regexp="^\\d+", message = "phone number must follow the pattern xxx-xxx-xxxx")
    private String phoneNumber;

    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email")
    private String email;

    @AssertTrue(message="You must agree to Terms and Conditions")
    private boolean acceptTerms;

    public Customer() { }

    public Customer(Integer ID, String username, String firstname,
                    String lastname, Date birthDate, String country,
                    String city, String street, String zipCode,
                    String phoneNumber, String email, boolean acceptTerms) {
        this.ID = ID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.acceptTerms = acceptTerms;
    }

    public Integer getID() { return ID; }

    public void setID(Integer ID) { this.ID = ID; }

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username; }

    public Date getBirthDate() {return birthDate;}

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getCountry() { return country;}

    public void setCountry(String country) {this.country = country;}

    public String getCity() { return city;}

    public void setCity(String city) { this.city = city;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public String getZipCode() {return zipCode;}

    public void setZipCode(String zipCode) {this.zipCode = zipCode;}

    public String getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public boolean getAcceptTerms() {return acceptTerms;}

    public void setAcceptTerms(boolean acceptTerms) {this.acceptTerms = acceptTerms;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return acceptTerms == customer.acceptTerms &&
                Objects.equals(ID, customer.ID) &&
                Objects.equals(username, customer.username) &&
                Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(zipCode, customer.zipCode) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, username, firstname, lastname, country, city, street, zipCode, phoneNumber, email, acceptTerms);
    }
}