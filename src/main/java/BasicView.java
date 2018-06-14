import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Customer> cars;

    @ManagedProperty("#{customerService}")
    private CustomerService service;

    @PostConstruct
    public void init() {
        cars = service.createUsers(10);
    }

    public List<Customer> getCars() {
        return cars;
    }

    public void setService(CustomerService service) {
        this.service = service;
    }
}
