package com.verizon.hackathon.sentiment.analysis.db;

import java.util.List;

import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public interface DictionaryDBLayer {
	
	List<String> retrieveKeywords(String type) throws ServerException;

}
