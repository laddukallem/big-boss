package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection 
{
	Connection con=null;
	
	
	public Connection getConnection() 
	{
		
		try {

	Class.forName("com.mysql.jdbc.Driver");
      
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
	System.out.println("****DBConnection.getConnection()*****");
		
	
		}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	 return con;
}
	
}