package dao;

import javax.ejb.Local;
import entity.Commande;

@Local
public interface OrderLocal {


    public void persist(java.lang.Object object);

    public void executeOrder(Commande order);
}
