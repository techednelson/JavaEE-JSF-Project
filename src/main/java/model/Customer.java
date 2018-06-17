package model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Customer {

    private String firstname;
    private String lastname;
    private String userName;
//    private String birthDate;
    private String country;
    private String city;
    private String street;
    private int zipCode;
    private String phoneNumber;
    private String email;
////    private boolean acceptTerms;
//
    public Customer() {    }

    public Customer(String userName, String firstname, String lastname) {
        this.userName = userName;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName; }

//    public String getBirthDate() {return birthDate;}
//
//    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getCountry() { return country;}

    public void setCountry(String country) {this.country = country;}

    public String getCity() { return city;}

    public void setCity(String city) { this.city = city;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public int getZipCode() {return zipCode;}

    public void setZipCode(int zipCode) {this.zipCode = zipCode;}

    public String getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }


//    public boolean getAcceptTerms() {return acceptTerms;}
//
//    public void setAcceptTerms(boolean acceptTerms) {this.acceptTerms = acceptTerms;}

}
