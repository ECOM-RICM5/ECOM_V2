package dao;

import entity.Commande;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Root
 */
@Stateless
public class OrderBean implements OrderLocal{


    @PersistenceContext
    private EntityManager em;
    
	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub
		em.persist(object);
	}

	@Override
	public void executeOrder(Commande order) {
		// TODO Auto-generated method stub
		em.persist(order);
	}

	
}
