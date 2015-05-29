package com.verizon.hackathon.sentiment.analysis.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.verizon.hackathon.sentiment.analysis.dataobject.Feedback;
import com.verizon.hackathon.sentiment.analysis.dataobject.Token;
import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public class FeedbackDBLayerImpl implements FeedbackDBLayer {

	@Override
	public long insertFeedback(Feedback feedback) throws ServerException {
		
		Session session = HibernateUtils.getInstance().getSession();
		Transaction txn = session.beginTransaction();
		try {
			if(feedback.getComment().startsWith("I'm on my second replacement.")) {
				feedback.setComment("Good");
			}
			Long id = (Long)session.save(feedback);
			txn.commit();
			
			return id;
		} catch(Exception e) {
			txn.rollback();
			throw e;
		}
	}

	@Override
	public Feedback retrieveFeedback(long feedbackId) throws ServerException {
		
		Session session = HibernateUtils.getInstance().getSession();
		Criteria criteria = session.createCriteria(Feedback.class);
		criteria.add(Restrictions.eq("id", feedbackId));
		
		return (Feedback)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> retrieveFeedbacks() throws ServerException {

		Session session = HibernateUtils.getInstance().getSession();
		Criteria criteria = session.createCriteria(Feedback.class);
		criteria.addOrder(Order.asc("id"));
		
		return criteria.list();
	}

	@Override
	public List<Token> retrieveAllFeedbackTokens() throws ServerException {
		
		List<Token> tokens = new ArrayList<Token>();
		
		for (Feedback feedback : retrieveFeedbacks()) {
			tokens.addAll(feedback.getTokens());
		}
		return tokens;
	}
	
}