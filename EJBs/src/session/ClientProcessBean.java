package session;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import dao.ClientLocal;
import entity.Client;

@Stateless
public class ClientProcessBean implements ClientProcessLocal {

	@EJB
    private ClientLocal customerDaoBean;
	

	public Client createClient(String prenom, String nom, String email,
			String pseudo, String adresse, String codePostal, String phone) {
		// TODO Auto-generated method stub
		  Client customer = new Client();
	      setCustomerAttribute(customer,adresse, codePostal, email, nom, prenom, pseudo,phone);
	      customerDaoBean.persist(customer);

	        return customer;
	}

	private void setCustomerAttribute(Client c,String adresse, String codePostal,
			String email, String nom, String prenom, String pseudo, String phone) {
		// TODO Auto-generated method stub
		c.setAdresse(adresse);
		c.setCodePostal(codePostal);
		c.setEmail(email);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setPseudo(pseudo);
		c.setTelephone(phone);
	}

	@Override
	public Client updateClient(int customerId, String prenom, String nom,
			String email, String pseudo, String adresse, String codePostal,
			String phone) {
		// TODO Auto-generated method stub
		Client customer = customerDaoBean.findCustomerById(customerId);
	    setCustomerAttribute(customer,adresse, codePostal, email, nom, prenom, pseudo,phone);
        customerDaoBean.mergeCustomer(customer);
        return customer;
		
	}

	@Override
	public Client getClientByEmail(String email) {
		// TODO Auto-generated method stub
		  Client customer = customerDaoBean.getCustomerByEmail(email);
	        if (customer != null) {
	            return customer;
	        }
	        return null;
	}

}
