package com.verizon.hackathon.sentiment.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.verizon.hackathon.sentiment.analysis.dataobject.Feedback;
import com.verizon.hackathon.sentiment.analysis.dataobject.Token;
import com.verizon.hackathon.sentiment.analysis.db.DictionaryDBLayer;
import com.verizon.hackathon.sentiment.analysis.db.DictionaryDBLayerImpl;
import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public class FeedbackAnalyzer {

	protected static Map<String, List<String>> keywords = new HashMap<String, List<String>>();
	protected DictionaryDBLayer dbLayer = new DictionaryDBLayerImpl();
	
	public FeedbackAnalyzer() {
		
		try {
			keywords.put("Positive", dbLayer.retrieveKeywords("Positive"));
			keywords.put("Negative", dbLayer.retrieveKeywords("Negative"));
			keywords.put("Superlative", dbLayer.retrieveKeywords("Superlative"));
		} catch (ServerException e) {}
	}

	public String execute(Feedback feedback) throws Exception {
		
		List<Token> tokens = feedback.getTokens();
		int rating = 0;
		for (Token token : tokens) {
			rating += calculateScore(token);
		}

		String result = "";
		if(rating > 0) {
			result = "Positive";
		} else if(rating < 0) {
			result = "Negative";
		} else {
			result = "Neutral";
		}
		return result;
	}
	
	private int calculateScore(Token token) {
		
		int result = compare(token.getWord()) + compare(token.getPreviousWord()) + compare(token.getNextWord());
		return result;
	}
	
	protected int compare(String word) {
		int score = 0;
		
		boolean isUpperCase = word.equals(word.toUpperCase());
		
		if(isPositive(word)) {
			score++;
			if(isUpperCase) {
				score++;
			}
		} 
		else if(isNegative(word)) {
			score--;
			if(isUpperCase) {
				score--;
			}
		}
		else if(isSuperlative(word)) {
			score+=2;
			if(isUpperCase) {
				score+=2;
			}
		}
		return score;
	}
	
	protected boolean isNegative(String word) {
		if(word == null || word.isEmpty()) {
			return false;
		}
		return (keywords.get("Negative").contains(word.toUpperCase()));
	}
	protected boolean isPositive(String word) {
		if(word == null || word.isEmpty()) {
			return false;
		}
		return (keywords.get("Positive").contains(word.toUpperCase()));
	}
	protected boolean isSuperlative(String word) {
		if(word == null || word.isEmpty()) {
			return false;
		}
		return (keywords.get("Superlative").contains(word.toUpperCase()));
	}
}
