package com.verizon.hackathon.sentiment.analysis.db;

import java.util.List;

import com.verizon.hackathon.sentiment.analysis.dataobject.Feedback;
import com.verizon.hackathon.sentiment.analysis.dataobject.Token;
import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public interface FeedbackDBLayer {
	
	long insertFeedback(Feedback feedback) throws ServerException;
	
	Feedback retrieveFeedback(long feedbackId) throws ServerException;
	
	List<Feedback> retrieveFeedbacks() throws ServerException;
	
	List<Token> retrieveAllFeedbackTokens() throws ServerException;

}
