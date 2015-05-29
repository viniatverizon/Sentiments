package com.verizon.hackathon.sentiment.analysis.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	
	public boolean checkDD(String token, String tableName)
	{
		boolean found = false;
		try
		{
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.createConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ".concat(tableName));
			while(rs.next())
			{
				found = true;
			}	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return found;
	}	

}
