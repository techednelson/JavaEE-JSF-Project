package model;

import java.util.Date;

public class Student {

    private Integer ID;
    private String username;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String country;
    private String city;
    private String street;
    private Integer zipCode;
    private Integer phoneNumber;
    private String email;
    private boolean acceptTerms;

    public Student() { }

    public Student(Integer ID, String username, String firstname,
                   String lastname, Date birthDate, String country,
                   String city, String street, Integer zipCode,
                   Integer phoneNumber, String email, boolean acceptTerms) {
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

    public Integer getZipCode() {return zipCode;}

    public void setZipCode(Integer zipCode) {this.zipCode = zipCode;}

    public Integer getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(Integer phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public boolean getAcceptTerms() {return acceptTerms;}

    public void setAcceptTerms(boolean acceptTerms) {this.acceptTerms = acceptTerms;}

}
