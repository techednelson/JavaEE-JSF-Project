package model;

import java.util.Date;

public class Student {

    private String username;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String country;
    private String city;
    private String street;
    private Integer zipCode;
    private String phoneNumber;
    private String email;
    private boolean acceptTerms;

    public Student() { }

    public Student(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }


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

    public Integer getZipCode() {return zipCode;}

    public void setZipCode(Integer zipCode) {this.zipCode = zipCode;}

    public String getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public boolean getAcceptTerms() {return acceptTerms;}

    public void setAcceptTerms(boolean acceptTerms) {this.acceptTerms = acceptTerms;}

}
