package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.BateauCommandee;

@Stateless
public class ArticleBean implements ArticleLocal {

    @PersistenceContext
    private EntityManager em;
    
	@Override
	public void persistLineItem(BateauCommandee item) {
		// TODO Auto-generated method stub
		em.persist(item);
	}

	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub
		em.persist(object);
	}

	
}
