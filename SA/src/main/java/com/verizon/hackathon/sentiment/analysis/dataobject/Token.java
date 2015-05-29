package com.verizon.hackathon.sentiment.analysis.dataobject;

import java.io.Serializable;

public class Token implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String word;
	private String previousWord;
	
	private String nextWord;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPreviousWord() {
		return previousWord;
	}

	public void setPreviousWord(String previousWord) {
		this.previousWord = previousWord;
	}

	public String getNextWord() {
		return nextWord;
	}

	public void setNextWord(String nextWord) {
		this.nextWord = nextWord;
	}
	
}
