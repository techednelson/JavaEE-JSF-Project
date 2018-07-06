package controller;

import model.Customer;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {

    private static final String USERNAME_PATTERN = "^\\b\\pL\\w*(?:-\\pL\\w*)*\\b";
    private static final String NAME_PATTERN = "^\\b\\pL+(?:-\\pL+)*\\b";
    private static final String NUMBER_PATTERN = "^\\d+";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(Customer customer) {
        return validateUsername(customer.getUsername()) &&
                validateName(customer.getFirstname()) &&
                validateName(customer.getLastname()) &&
                validateDate(customer.getBirthDate()) &&
                validateLocation(customer.getCountry()) &&
                validateLocation(customer.getCity()) &&
                validateStreet(customer.getStreet()) &&
                validateNumber(customer.getPhoneNumber()) &&
                validateNumber(customer.getZipCode()) &&
                validateEmail(customer.getEmail()) &&
                validateTerms(customer.getAcceptTerms());
    }

    private boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean validateName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean validateDate(Date date) {
       return date != null;
    }

    private boolean validateLocation(String country) {
        if(country != null) {
            return !country.equals("");
        }

        return false;
    }

    private boolean validateStreet(String street) { return street.length() > 5 && street.length() < 35; }

    private boolean validateNumber(String number) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateTerms(boolean terms) { return terms; }

}
