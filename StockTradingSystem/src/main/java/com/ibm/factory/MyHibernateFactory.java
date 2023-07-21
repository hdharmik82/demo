package com.ibm.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.bean.Order;
import com.ibm.bean.Stock;

public class MyHibernateFactory {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Stock.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();
		return sessionFactory;
	}

}