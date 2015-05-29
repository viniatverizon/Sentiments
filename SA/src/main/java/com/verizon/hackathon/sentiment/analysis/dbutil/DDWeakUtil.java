package com.verizon.hackathon.sentiment.analysis.dbutil;

public class DDWeakUtil {
	public boolean checkDD(String token)
	{
		DBUtil dbUtil = new DBUtil();
		return dbUtil.checkDD(token, "datadictionaryweak");
	}
}
