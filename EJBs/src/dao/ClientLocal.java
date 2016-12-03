package dao;
import javax.ejb.Local;
import entity.Client;


@Local
public interface ClientLocal {

    public void persist(java.lang.Object object);

    public Client findCustomerById(int customerId);

    public Client getCustomerByEmail(String email);

    public void mergeCustomer(Client customer);
    
}
