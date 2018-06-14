import java.util.Date;

public class Customer {

    // private String id;
    // private String brand;
    // private int year;
    // private String color;
    // private int price;
    // private boolean soldState;
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

    public Customer(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // public Customer(String id, String brand, int year, String color, int price, boolean soldState) {
    //     this.id = id;
    //     this.brand = brand;
    //     this.year = year;
    //     this.color = color;
    //     this.price = price;
    //     this.soldState = soldState;
    // }

    // public String getId() { return id;}

    // public void setId(String id) { this.id = id;}

    // public String getBrand() { return brand;}

    // public void setBrand(String brand) { this.brand = brand; }

    // public int getYear() { return year;}

    // public void setYear(int year) {this.year = year;}

    // public String getColor() { return color; }

    // public void setColor(String color) { this.color = color;}

    // public int getPrice() { return price; }

    // public void setPrice(int price) { this.price = price; }

    // public boolean isSoldState() { return soldState;}

    // public void setSoldState(boolean soldState) { this.soldState = soldState; }

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
