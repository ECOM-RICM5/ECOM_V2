package session;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import entity.BateauCommandee;
import entity.Commande;
import util.BoatException;


@Local
public interface PanierLocal {

	public void initialize(String client) throws BoatException;
	
    public void initialize(String client, String id) throws BoatException;
    
    public void addBoat(String title);
    
    public void removeBoat(String title) throws BoatException;
    
    public List<String> getContents();
    
    public void remove();
    
    
    public java.util.List<BateauCommandee> getLineItemList();

    public BateauCommandee getLineItemByProduct(int productId);

    public Commande getPurchaseOrder();

    public void setLineItemList(java.util.List< BateauCommandee> lineItemList);

    public void addLineItem(int productId, short quantity);


    public void deleteLineItem(int articleId);

    public BigDecimal getTotalPriceLineItemList();
    
}
