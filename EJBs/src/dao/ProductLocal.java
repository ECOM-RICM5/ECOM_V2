package dao;
import javax.ejb.Local;

import entity.Bateau;

@Local
public interface ProductLocal {


    public Bateau getProductByProductId(int productId);

    public void persist(java.lang.Object object);

    public java.util.Collection<Bateau> getProductList();

    public void addProduct(Bateau product);

    public java.util.Collection<Bateau> getProductListByCategoryId(Long categoryId);

}
