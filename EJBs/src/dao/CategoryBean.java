package dao;

import entity.Categorie;
import enumeration.Categories;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryBean implements CategoryLocal {

    @EJB
    private ProductLocal productDaoBean;
    @PersistenceContext(unitName="BoatDB")
    private EntityManager em;
    
    Categorie category;

    
	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub
		em.persist(object);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		  for (Iterator it = getCategoryList().iterator(); it.hasNext();) {
	            Object object = it.next();
	            em.remove(object);

	        }
	        for (Iterator it = productDaoBean.getProductList().iterator(); it.hasNext();) {
	            Object object = it.next();
	            em.remove(object);
	        }
	}

	@Override
	public Collection<Categorie> getCategoryList() {
		// TODO Auto-generated method stub
		return (Collection<Categorie>) em.createNamedQuery("Category.findAll").getResultList();
	}

	@Override
	public Categorie getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		System.out.println(em);
		return (Categorie) em.createNamedQuery("Category.findByCategoryName").setParameter("categoryName", categoryName).getSingleResult();
    
	}

	@Override
	public Categorie addCategory(String name) {
		// TODO Auto-generated method stub
		  category = new Categorie();
	      category.setNom(name);
	      em.persist(category);
	      return category;
	}

	@Override
	public void createCategory() {
		// TODO Auto-generated method stub
		  addCategory(Categories.MOTEUR.getCategoryText());
	      addCategory(Categories.VOILE.getCategoryText());
	      addCategory(Categories.PENICHE.getCategoryText());
	      addCategory(Categories.GONFLABLE.getCategoryText());
	      addCategory(Categories.JET.getCategoryText());
	      addCategory(Categories.ALU.getCategoryText());
	      
	}

}
