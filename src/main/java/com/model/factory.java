package com.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class factory {
	
	public static SessionFactory factory;
	public static SessionFactory getFactory() {
		
		if(factory==null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return factory;
	}
	
	public void closeFactory() {
//		if(((Object) factory).isOpen()) {
			factory.close();
		}
	}

