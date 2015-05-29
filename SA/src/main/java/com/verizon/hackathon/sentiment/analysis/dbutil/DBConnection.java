package com.verizon.hackathon.sentiment.analysis.dbutil;

import java.sql.*;

import com.verizon.hackathon.sentiment.analysis.util.Environment;

public class DBConnection {
	
	public Connection createConnection()
	{
		Connection con = null;
		try
		{
			String dbdriver = Environment.getInstance().getProperty("DBDRIVER");
			String url = Environment.getInstance().getProperty("DBURL");
			String usr = Environment.getInstance().getProperty("DBUSR");
			String pwd = Environment.getInstance().getProperty("DBPWD");
			Class.forName(dbdriver);
			con = DriverManager.getConnection(url,usr,pwd);
			System.out.println("Yes Boss..");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}	
	
	public static void main(String a[])
	{
		DBConnection dbcon = new DBConnection();
		dbcon.createConnection();
	}
}
