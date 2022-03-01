package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	static Connection c=null;
	public static Connection getCon()
	{
		try 
		{
		if(c==null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
			return c;
		}
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		return c;
	}
}
