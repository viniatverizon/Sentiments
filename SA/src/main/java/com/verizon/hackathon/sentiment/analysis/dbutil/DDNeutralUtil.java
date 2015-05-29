package com.verizon.hackathon.sentiment.analysis.dbutil;

public class DDNeutralUtil {
	
	public boolean checkDD(String token)
	{
		DBUtil dbUtil = new DBUtil();
		return dbUtil.checkDD(token, "datadictionaryneutral");
	}

}
