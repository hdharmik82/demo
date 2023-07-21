package com.ibm.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.bean.Stock;
import com.ibm.factory.MyHibernateFactory;

@Repository
public class ClientDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Session session = null;
	{
		sessionFactory = MyHibernateFactory.getSessionFactory();
	}
	
	@Transactional
	public List<Stock> getAllStocks() {
		session = sessionFactory.openSession();
		TypedQuery<Stock> query = session.createQuery("FROM Stock s",Stock.class);
		List<Stock> list = query.getResultList();
		
		return list;
	}
}	
