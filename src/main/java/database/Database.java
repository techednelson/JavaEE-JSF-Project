package database;

import model.Customer;

import java.util.*;

public class Database {

    private static  List<Customer> customers;

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(Customer customer) {
        customers.add(customer);
    }


    static  {

        customers = new ArrayList<>();
        Customer customer;

        customer = new Customer(1, "Snake", "John", "Smith", new Date(), "USA", "New York", "apple 4", "12345", "0123456789", "snake@gmail.com", true);
        customers.add(customer);
        customer = new Customer(2, "Cowboy", "George", "Lopez", new Date(), "Greece", "Athens", "apple 4", "12345", "0123456789", "cowboy@gmail.com", true);
        customers.add(customer);
        customer = new Customer(3, "Batman", "Luis", "Williams", new Date(), "England", "Liverpool", "apple 4", "12345", "0123456789", "batman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(4, "Hulk", "Miguel", "Woods", new Date(), "Spain", "Sevilla", "apple 4", "12345", "0123456789", "hulk@gmail.com", true);
        customers.add(customer);
        customer = new Customer(5, "Prime", "Angel", "Fierro", new Date(), "Mexico", "Guadalajara", "apple 4", "12345", "0123456789", "prime@gmail.com", true);
        customers.add(customer);
        customer = new Customer(6, "Ironman", "Oscar", "Johnson", new Date(), "USA", "Chicago", "apple 4", "12345", "0123456789", "ironman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(7, "Superman", "Charles", "Jones", new Date(), "Greece", "Ioannina", "apple 4", "12345", "0123456789", "superman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(8, "Torn", "Alicia", "Brown", new Date(), "England", "Leeds", "apple 4", "12345", "0123456789", "torn@gmail.com", true);
        customers.add(customer);
        customer = new Customer(9, "Robin", "Helen", "Davis", new Date(), "Spain", "Madrid", "apple 4", "12345", "0123456789", "robin@gmail.com", true);
        customers.add(customer);
        customer = new Customer(10, "Ant-man", "Laura", "Miler", new Date(), "Mexico", "Monterrey", "apple 4", "12345", "0123456789", "antman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(11, "Aquaman", "Gloria", "Wilson", new Date(), "USA", "Denver", "apple 4", "12345", "0123456789", "aquaman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(12, "Asterix", "Debby", "Mandela", new Date(), "Greece", "Thessaloniki", "apple 4", "12345", "0123456789", "asterix@gmail.com", true);
        customers.add(customer);
        customer = new Customer(13, "Daredevil", "Gael", "Jimenez", new Date(), "England", "Manchester", "apple 4", "12345", "0123456789", "daredevil@gmail.com", true);
        customers.add(customer);
        customer = new Customer(14, "Elektra", "Pedro", "Young", new Date(), "Spain", "Barcelona", "apple 4", "12345", "0123456789", "elektra@gmail.com", true);
        customers.add(customer);
        customer = new Customer(15, "Hellboy", "Mauricio", "Hernandez", new Date(), "Mexico", "Mexico City", "apple 4", "12345", "0123456789", "hellboy@gmail.com", true);
        customers.add(customer);
        customer = new Customer(16, "Wolverine", "Homer", "King", new Date(), "USA", "San Francisco", "apple 4", "12345", "0123456789", "wolverine@gmail.com", true);
        customers.add(customer);
        customer = new Customer(17, "x-men", "Beyonce", "Green", new Date(), "Greece", "Kalamata", "apple 4", "12345", "0123456789", "xmen@gmail.com", true);
        customers.add(customer);
        customer = new Customer(18, "Wonderwoman", "Issac", "Perez", new Date(), "England", "London", "apple 4", "12345", "0123456789", "wonderwoman@gmail.com", true);
        customers.add(customer);
        customer = new Customer(19, "Badgirl", "Harry", "Phillips", new Date(), "Spain", "Valencia", "apple 4", "12345", "0123456789", "badgirl@gmail.com", true);
        customers.add(customer);
        customer = new Customer(20, "Prime", "Edgar", "Parker", new Date(), "Mexico", "Puebla", "apple 4", "12345", "0123456789", "prime@gmail.com", true);
        customers.add(customer);

    }

    public static Map<String, String> getCountries() {

        Map<String, String> countries;

        countries = new HashMap<>();
        countries.put("Greece", "Greece");
        countries.put("England", "England");
        countries.put("Mexico", "Mexico");
        countries.put("Spain", "Spain");
        countries.put("USA", "USA");

       return countries;
    }

    public static Map<String, Map<String, String>> getCities() {

        Map<String, Map<String, String>> data = new HashMap<>();

        Map<String, String> map = new HashMap<>();
        map.put("Thessaloniki", "Thessaloniki");
        map.put("Patra", "Patra");
        map.put("Ioannina", "Ioannina");
        map.put("Kalamata", "Kalamata");
        map.put("Athens", "Athens");
        data.put("Greece", map);

        map = new HashMap<>();
        map.put("London", "London");
        map.put("Leeds", "Leeds");
        map.put("Manchester", "Manchester");
        map.put("Liverpool", "Liverpool");
        map.put("New Castle", "New Castle");
        data.put("England", map);

        map = new HashMap<>();
        map.put("Mexico City", "Mexico City");
        map.put("Monterrey", "Monterrey");
        map.put("Guadalajara", "Guadalajara");
        map.put("Leon", "Leon");
        map.put("Puebla", "Puebla");
        data.put("Mexico", map);

        map = new HashMap<>();
        map.put("Madrid", "Madrid");
        map.put("Sevilla", "Sevilla");
        map.put("Barcelona", "Barcelona");
        map.put("Malaga", "Malaga");
        map.put("Valencia", "Valencia");
        data.put("Spain", map);

        map = new HashMap<>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        map.put("Los Angeles", "Los Angeles");
        map.put("Chicago", "Chicago");
        data.put("USA", map);

        return data;
    }

}
