package dao;
import java.util.Collection;

import entity.Bateau;

import enumeration.Categories;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductBean implements ProductLocal {

	  	@EJB
	    private CategoryLocal categoryDaoBean;
	    @PersistenceContext(unitName="BoatDB")
	    private EntityManager em;
	    Bateau product;
	    
	
	public Bateau getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		  return (Bateau) em.createNamedQuery("Product.findByProductId").setParameter("productId", productId).getSingleResult();
	}

	
	public void persist(Object object) {
		// TODO Auto-generated method stub
		em.persist(object);
	}

	
	public Collection<Bateau> getProductList() {
		// TODO Auto-generated method stub
			System.out.println(em);
		  return (Collection<Bateau>) em.createNamedQuery("Product.findAll").getResultList();
	}

	
	public void addProduct(Bateau bateau) {
		// TODO Auto-generated method stub
		em.persist(bateau);
	}


	public Collection<Bateau> getProductListByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return (Collection<Bateau>) em.createNamedQuery("Product.findByCategoryId").setParameter("categoryId", categoryId).getResultList();
	}


}
