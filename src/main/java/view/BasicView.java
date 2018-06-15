package view;

import model.Customer;
import VacanciesService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Customer> customers;

    @ManagedProperty("#{customerService}")
    private VacanciesService service;

    @PostConstruct
    public void init() {
        customers = service.createUsers(5);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setService(VacanciesService service) {
        this.service = service;
    }

}