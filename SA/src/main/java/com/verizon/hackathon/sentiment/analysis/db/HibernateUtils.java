package com.verizon.hackathon.sentiment.analysis.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.verizon.hackathon.sentiment.analysis.dataobject.Feedback;

public class HibernateUtils {

	private static HibernateUtils singleton;
	private SessionFactory sessionFactory = null;
	
	private HibernateUtils() {
		
		// 1. configuring hibernate
		Configuration configuration = new Configuration().configure();

		// 2. create sessionfactory
		sessionFactory = configuration.buildSessionFactory();
	}

	public static HibernateUtils getInstance() {
		
		if(singleton == null) {
			singleton = new HibernateUtils();
		}
		
		return singleton;
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().getSession();
		session.save(new Feedback("Testing"));
		session.close();
	}

}
