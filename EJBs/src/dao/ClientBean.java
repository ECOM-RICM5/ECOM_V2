package dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import entity.Client;

@Stateless
public class ClientBean implements ClientLocal{

	  @PersistenceContext
	  private EntityManager em;
	  
	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub
		  em.persist(object);
	}

	@Override
	public Client findCustomerById(int customerId) {
		// TODO Auto-generated method stub
        return (Client)em.createNamedQuery("Customer.findByCustomerId").setParameter("customerId", customerId).getSingleResult();

	}

	@Override
	public Client getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		  Client customer = null;
	        try {
	            customer = (Client) em.createNamedQuery("Customer.findByCustomerMail").setParameter("email", email).getSingleResult();
	        } catch (NoResultException e) {
	            System.out.println("Ce client n'existe pas.");
	        }
	        return customer;
	}

	@Override
	public void mergeCustomer(Client customer) {
		// TODO Auto-generated method stub
		em.merge(customer);
		
	}

}
