package com.verizon.hackathon.sentiment.analysis.dataobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String comment = "";
	private Date feedbackDTTM = new Date();
	private Date createDTTM = new Date();
	
	public Feedback() {
	}
	
	public Feedback(String comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getFeedbackDTTM() {
		return feedbackDTTM;
	}

	public void setFeedbackDTTM(Date feedbackDTTM) {
		this.feedbackDTTM = feedbackDTTM;
	}

	public Date getCreateDTTM() {
		return createDTTM;
	}

	public void setCreateDTTM(Date createDTTM) {
		this.createDTTM = createDTTM;
	}

	public List<Token> getTokens() {
		List<Token> tokens = new ArrayList<Token>();
		
		String[] words = comment.split(" ");
		for (int idx = 0; idx < words.length; idx++) {
			Token token = new Token();
			token.setId(id);
			token.setWord(words[idx]);
			token.setPreviousWord((idx != 0) ? words[idx-1] : "");
			token.setNextWord((idx != words.length -1) ? words[idx+1] : "");
			tokens.add(token);
		}
		return tokens;
	}
	
	@Override
	public String toString() {
		return  "Id: [" + id + "]" 
			  + "Comments: [" + comment + "]"
			  + "FeedbackDate: [" + feedbackDTTM + "]"
			  + "CreateDate: [" + createDTTM + "]";
	}
	
}
