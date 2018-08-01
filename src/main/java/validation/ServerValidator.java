package validation;

import model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Set;

@Stateless
public class ServerValidator implements Serializable {

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
