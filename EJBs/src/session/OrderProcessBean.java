package session;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ArticleLocal;
import dao.ClientLocal;
import dao.OrderLocal;
import entity.BateauCommandee;
import entity.Commande;

@Stateless
public class OrderProcessBean implements OrderProcessLocal{

	  	@EJB
	    private ArticleLocal articleBean;
	    @EJB
	    private OrderLocal oderBean;
	    @EJB
	    private ClientLocal clientBean;

	@Override
	public Commande order(int customerId, PanierLocal cartProcessBean) {
		// TODO Auto-generated method stub
		  for (Iterator it = cartProcessBean.getLineItemList().iterator(); it.hasNext();) {
	            BateauCommandee item = (BateauCommandee) it.next();
	            item.setId(null);
	            articleBean.persistLineItem(item);
	        }
	        Commande order = new Commande();
	        order.setDateCommande(new Timestamp(System.currentTimeMillis()));
	        order.setClient(clientBean.findCustomerById(customerId));
	        order.setBateauCommandees(cartProcessBean.getLineItemList());
	        
	        //order.setTotalPrice(cartProcessBean.getTotalPriceLineItemList());
	        
	        oderBean.executeOrder(order);

	        return order;
	}



}
