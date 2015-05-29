package com.verizon.hackathon.sentiment.analysis.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.verizon.hackathon.sentiment.analysis.FeedbackAnalyzer;
import com.verizon.hackathon.sentiment.analysis.dataobject.Feedback;
import com.verizon.hackathon.sentiment.analysis.db.FeedbackDBLayer;
import com.verizon.hackathon.sentiment.analysis.db.FeedbackDBLayerImpl;
import com.verizon.hackathon.sentiment.analysis.exception.ServerException;

public class FeedbackReport {

	public static void main(String[] args) throws Exception {

		FeedbackDBLayer dbLayer = new FeedbackDBLayerImpl();
		
		readFeedback(dbLayer);
		writeFeedback(dbLayer);
		
	}
	
	public static void readFeedback(FeedbackDBLayer dbLayer) throws IOException, FileNotFoundException {
	
		String infile = Environment.getInstance().getProperty("INPUTFILE");
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
			String line = "";
			while((line = in.readLine()) != null ) {				
				
				try {
					Feedback feedback = new Feedback(line);
					
					dbLayer.insertFeedback(feedback);
				}
				catch (Exception e) {
					// Ignore it
					System.out.println(line);
					System.out.println(e);
				}
			}
		}
		finally {
			in.close();
		}
	}
	
	public static void writeFeedback(FeedbackDBLayer dbLayer) throws ServerException, Exception {
		
		String infile = Environment.getInstance().getProperty("OUTPUTFILE");
		FeedbackAnalyzer analyzer = new FeedbackAnalyzer();
		PrintWriter out = null;
		try {
			out = new PrintWriter(infile);
			for (Feedback feed : dbLayer.retrieveFeedbacks()) {
				String result = analyzer.execute(feed);
				//System.out.println(feed.getComment() + " - " + result);
				out.println(result);
			}
		}
		finally {
			out.close();
		}
	}

}
