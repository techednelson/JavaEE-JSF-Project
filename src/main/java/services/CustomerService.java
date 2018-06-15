package services;

import model.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "customerService")
@ApplicationScoped
public class CustomerService {

    private final static String[] users;
    private final static String[] firstNames;
    private final static String[] lastNames;

    static {
        users = new String[10];
        users[0] = "Snake";
        users[1] = "Cowboy";
        users[2] = "Prime";
        users[3] = "Batman";
        users[4] = "Spiderman";
        users[5] = "Ironman";
        users[6] = "Hulk";
        users[7] = "Wonderwoman";
        users[8] = "Torn";
        users[9] = "Maroon5";

        firstNames = new String[10];
        firstNames[0] = "John";
        firstNames[1] = "George";
        firstNames[2] = "Luis";
        firstNames[3] = "Miguel";
        firstNames[4] = "Jenifer";

        lastNames = new String[10];
        lastNames[0] = "Smith";
        lastNames[1] = "Lopez";
        lastNames[2] = "Williams";
        lastNames[3] = "Woods";
        lastNames[4] = "Hierro";
    }

    public List<Customer> createUsers(int size) {
        List<Customer> list = new ArrayList<Customer>();
        Customer customer;

        for(int i = 0 ; i < size ; i++) {
            customer = new Customer(users[i], firstNames[i], lastNames[i]);
            list.add(customer);
        }

        return list;
    }

}
