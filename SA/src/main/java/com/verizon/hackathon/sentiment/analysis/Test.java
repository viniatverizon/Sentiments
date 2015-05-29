package com.verizon.hackathon.sentiment.analysis;

import java.util.Arrays;
import java.util.List;

import com.verizon.hackathon.sentiment.analysis.dataobject.Token;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Token token = new Token();
		token.setWord("BLAZING");
		token.setNextWord("fast");
		token.setPreviousWord("");
		
		String current = token.getWord();
		String previous = token.getPreviousWord();
		String next = token.getNextWord();
		
		System.out.println(current);
		System.out.println(current.equals(current.toUpperCase()));
		System.out.println(current);
	}

}
