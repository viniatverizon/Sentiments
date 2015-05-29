package com.verizon.hackathon.sentiment.analysis.dataobject;

import java.io.Serializable;

public class Dictionary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String keyword = "";

	public Dictionary() {
	}

	public Dictionary(String type, String keyword) {
		this.type = type;
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}