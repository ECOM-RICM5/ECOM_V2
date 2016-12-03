package session;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CategoryBean;
import dao.CategoryLocal;
import dao.ProductBean;
import dao.ProductLocal;
import entity.Bateau;
import entity.Categorie;
import enumeration.Categories;

@Stateless
public class ProductProcessBean implements ProductProcessLocal {

    @EJB
    private CategoryLocal categoryBean= new CategoryBean();
    @EJB
    private ProductLocal productBean= new ProductBean();
    
    //add a quantity column in the bateau table
	@Override
	public void updateQuantity(int id, int quantity) {
		// TODO Auto-generated method stub
		 /* Bateau product = productBean.getProductByProductId(id);
	       // int remainQuantity = product.getQuantite() - quantity;
	        if (remainQuantity > 0) {
	            product.setQuantity(remainQuantity);
	        } else {
	            product.setQuantity(0);
	            product.setAvailability(false);
	        }*/
	}

	private Bateau setBoat(String description,int disponibilite, String nom, BigDecimal prix,
			Categorie categorie){
		Bateau b = new Bateau();
		b.setCategorie(categorie);
		b.setDescription(description);
		b.setDisponibilite(disponibilite);
		b.setNom(nom);
		b.setPrix(prix);
		return b;
	}
	@Override
	public void createProduct() {
		// TODO Auto-generated method stub,
		
		productBean.addProduct(setBoat("bateau petit modèle", 1,"MYlittle boat", new BigDecimal(15488), categoryBean.getCategoryByName(Categories.PENICHE.getCategoryText())));
		productBean.addProduct(setBoat("bateau familial 35m grand modèle", 1,"MYbig 58 boat", new BigDecimal(352488), categoryBean.getCategoryByName(Categories.MOTEUR.getCategoryText())));
		
	}

}
