package com.verizon.hackathon.sentiment.analysis.dbutil;

public class DDSuperlativeUtil {

	public boolean checkDD(String token)
	{
		DBUtil dbUtil = new DBUtil();
		return dbUtil.checkDD(token, "datadictionarysuperlative");
	}
}
