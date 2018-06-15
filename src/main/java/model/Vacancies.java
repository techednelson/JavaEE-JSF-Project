package model;

import java.util.Date;

public class Vacancies {

    private String firstName;
    private String lastName;
    private String userName;
    private Date birthDate;
    private String country;
    private String city;
    private String street;
    private int zipcode;
    private String phoneNumber;
    private String email;
    private boolean acceptTerms;

    public Vacancies(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName; }

    public Date getBirthDate() {return birthDate;}

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getCountry() { return country;}

    public void setCountry(String country) {this.country = country;}

    public String getCity() { return city;}

    public void setCity(String city) { this.city = city;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public int getZipcode() {return zipcode;}

    public void setZipcode(int zipcode) {this.zipcode = zipcode;}

    public String getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public boolean getAcceptTerms() {return acceptTerms;}

    public void setAcceptTerms(boolean acceptTerms) {this.acceptTerms = acceptTerms;}

}
