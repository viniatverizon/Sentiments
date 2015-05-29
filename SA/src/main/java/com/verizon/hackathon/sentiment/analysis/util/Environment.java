package com.verizon.hackathon.sentiment.analysis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Environment {

	private Properties properties = new Properties();
	private static final String propertyFile = "config/common-config.properties";
	
	private static Environment singleton;
	
	private Environment() {
		
		InputStream in = getClass().getClassLoader().getResourceAsStream(propertyFile);
		try {
			properties.load(in);
		} catch (IOException e) {
			// Error while reading the file.
		}
	}

	public static Environment getInstance() {
		
		if(singleton == null) {
			singleton = new Environment();
		}
		
		return singleton;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName = Environment.getInstance().getProperty("INPUTFILE");
		System.out.println(fileName);
	}

}
