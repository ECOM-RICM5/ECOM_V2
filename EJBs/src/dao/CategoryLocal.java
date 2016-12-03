package dao;
import javax.ejb.Local;


@Local
public interface CategoryLocal {

	  public void persist(java.lang.Object object);

	    public void deleteAll();

	    public java.util.Collection<entity.Categorie> getCategoryList();

	    public entity.Categorie getCategoryByName(String categoryName);

	    public entity.Categorie addCategory(String name);

	    public void createCategory();	
	
}
