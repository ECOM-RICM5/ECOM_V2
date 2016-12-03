package dao;

import javax.ejb.Local;
import entity.BateauCommandee;

@Local
public interface ArticleLocal {


    public void persistLineItem(BateauCommandee item);

    public void persist(java.lang.Object object);
    
}
