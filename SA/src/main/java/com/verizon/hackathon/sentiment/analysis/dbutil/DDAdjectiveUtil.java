package com.verizon.hackathon.sentiment.analysis.dbutil;

public class DDAdjectiveUtil {
	
	public boolean checkDD(String token)
	{
		DBUtil dbUtil = new DBUtil();
		return dbUtil.checkDD(token, "datadictionaryadjective");
	}
	
	public boolean updateDDAdjective()
	{
		return true;
	}

}
