package com.verizon.hackathon.sentiment.analysis.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.verizon.hackathon.sentiment.analysis.dataobject.Dictionary;
import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public class DictionaryDBLayerImpl implements DictionaryDBLayer {
	
	public void init() throws ServerException {
//		insertDictionary(new Dictionary("Positive", "amazing"));
//		insertDictionary(new Dictionary("Positive", "blazing"));
//		insertDictionary(new Dictionary("Positive", "rocks"));
//		insertDictionary(new Dictionary("Positive", "good"));
//		insertDictionary(new Dictionary("Negative", "breeze"));
//		insertDictionary(new Dictionary("Negative", "horrible"));
//		insertDictionary(new Dictionary("Negative", "summer"));
//		insertDictionary(new Dictionary("Negative", "cancel"));
//		insertDictionary(new Dictionary("Negative", "bad"));
//		insertDictionary(new Dictionary("Negative", "not"));
	}
	
	public void insertDictionary(Dictionary dictionary) throws ServerException {
		
		Session session = HibernateUtils.getInstance().getSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(dictionary);
			txn.commit();
		} catch(Exception e) {
			txn.rollback();
			throw e;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> retrieveKeywords(String type) throws ServerException {
		
		Session session = HibernateUtils.getInstance().getSession();
		Query query = session.createQuery("Select UPPER(d.keyword) from Dictionary d where d.type = :type order by d.keyword");
		query.setString("type", type);
		
		return query.list();
	}
	
	
	public static void main(String[] args) throws ServerException {
		
		DictionaryDBLayerImpl dbLayer = new DictionaryDBLayerImpl();
		
		dbLayer.init();
		System.out.println("Negative : " + dbLayer.retrieveKeywords("Negative"));
		System.out.println("Positive : " + dbLayer.retrieveKeywords("Positive"));
	}
	
}
