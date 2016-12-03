package session;

import javax.ejb.Local;

import entity.Commande;

@Local
public interface OrderProcessLocal {

    public Commande order(int clientId, PanierLocal cartProcessBean);

}
