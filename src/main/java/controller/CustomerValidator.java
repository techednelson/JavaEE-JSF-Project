package controller;

import model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Stateless
public class CustomerValidator {


    @Inject
    private Validator validator;

    public boolean validateCustomer(Customer customer) {

        if(customer != null) {
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(customer);

            return constraintViolations.isEmpty();
        }
        return false;

    }



}
