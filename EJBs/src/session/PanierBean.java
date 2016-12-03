package session;
import util.BoatException;
import util.IdVerifier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import dao.ProductLocal;
import entity.Bateau;
import entity.BateauCommandee;
import entity.Commande;


@Stateful
public class PanierBean implements PanierLocal, Serializable {

	 String clientName;
	 String clientId;
	 List<String> contents;
	 
	 public List<String> getContents() {
		return contents;
	}

	@EJB
	 private ProductLocal productDaoBean;
	 private Commande order;
	 private List <BateauCommandee> lineItemList;
	 
	 public PanierBean() {
	        this.lineItemList = new ArrayList<BateauCommandee>();
	 }
	    
	public void initialize(String client) throws BoatException {
		// TODO Auto-generated method stub
		   if (client == null) {
	            throw new BoatException("Null client not allowed.");
	        } else {
	            clientName = client;
	        }

	        clientId = "0";
	        contents = new ArrayList<String>();
	}

	public  void initialize(String client, String id) throws BoatException {
		// TODO Auto-generated method stub
		  if (client == null) {
	            throw new BoatException("Null client not allowed.");
	        } else {

	            clientName = client;
	        }

		  IdVerifier idChecker = new IdVerifier();
	        if (idChecker.validate(id)) {
	            clientId = id;
	        } else {
	            throw new BoatException("Invalid id: " + id);
	        }

	        contents = new ArrayList<String>();
	}

	@Override
	public void addBoat(String name) {
		// TODO Auto-generated method stub
		  contents.add(name);
	}

	@Override
	public void removeBoat(String boat) throws BoatException {
		// TODO Auto-generated method stub
		   boolean result = contents.remove(boat);
	        if (!result) {
	            throw new BoatException(boat + "  is not in the cart.");
	        }
	}



	@Remove
	public void remove() {
		// TODO Auto-generated method stub
		this.lineItemList=null;
		
	}

	
	public List<BateauCommandee> getLineItemList() {
		// TODO Auto-generated method stub
		return lineItemList;
	}

	public BateauCommandee getLineItemByProduct(int productId) {
		// TODO Auto-generated method stub
		BateauCommandee lineItem = null;
        if ((lineItemList != null) && (!lineItemList.isEmpty())) {
            for (Iterator<BateauCommandee> it = lineItemList.iterator(); it.hasNext();) {
            	BateauCommandee item = it.next();
                if (item.getBateau().getId()==productId) {
                    lineItem = item;
                }
            }
        }
        return lineItem;
	}

	
	public Commande getPurchaseOrder() {
		// TODO Auto-generated method stub
		if (order == null) {
            order = new Commande();
        }
        return order;
		
	}

	public void setLineItemList(List<BateauCommandee> lineItemList) {
		// TODO Auto-generated method stub
		this.lineItemList = lineItemList;
	}

	public void addLineItem(int productId, short quantity) {
		// TODO Auto-generated method stub
	      BateauCommandee lineItem = getLineItemByProduct(productId);
	        Bateau product = productDaoBean.getProductByProductId(productId);
	        if (lineItem == null) {
	        	BateauCommandee temp=new BateauCommandee();
	        	temp.setBateau(product);
	        	temp.setQuantite(quantity);
	            lineItem = getPurchaseOrder().addBateauCommandee(temp);
	            if (!lineItemList.contains(lineItem)) {
	                lineItemList.add(lineItem);
	            }
	        } else {
	            getPurchaseOrder().addBateauCommandee(lineItem);
	        }
	}



	public void deleteLineItem(int articleId) {
		// TODO Auto-generated method stub
		  List<BateauCommandee> lineItemListTest = new ArrayList<BateauCommandee>();
	        for (Iterator<BateauCommandee> it = lineItemList.iterator(); it.hasNext();) {
	        	BateauCommandee lineItem = it.next();
	            if (lineItem.getId().equals(articleId)) {
	                lineItemListTest.add(lineItem);
	            }
	        }
	        lineItemList.removeAll(lineItemListTest);
	}

	@Override
	public BigDecimal getTotalPriceLineItemList() {
		// TODO Auto-generated method stub
		BigDecimal totalPrice = new BigDecimal(0);
        for (Iterator<BateauCommandee> it = lineItemList.iterator(); it.hasNext();) {
            BateauCommandee lineItem = it.next();
            totalPrice =((lineItem.getBateau().getPrix()).multiply(new BigDecimal(lineItem.getQuantite()))).add(totalPrice);
        }
        return totalPrice;
	}



	
}
