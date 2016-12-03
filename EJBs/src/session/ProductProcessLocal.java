package session;

import javax.ejb.Local;

@Local
public interface ProductProcessLocal {

	public void updateQuantity(int id, int quantity);

    public void createProduct();
    
}
