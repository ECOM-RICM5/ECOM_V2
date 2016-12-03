package session;

import javax.ejb.Local;


import entity.Client;

@Local
public interface ClientProcessLocal {
	
	  public Client createClient(String prenom,String nom,String email, String pseudo,String adresse, String codePostal, String phone);

	    public Client updateClient(int customerId, String prenom,String nom,String email, String pseudo,String adresse, String codePostal, String phone);

	    public Client getClientByEmail(String mail);


}
