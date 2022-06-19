package com.amazone.test;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

public class dataConnect {
	public Connection connection;
	public Statement state;
	List<String>result = new ArrayList<String>();
	public void getConnection() throws ClassNotFoundException, SQLException
	{
try {
		//Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazonerac", "root", "root");
	
}catch(NullPointerException e)
{
	e.getMessage();
}
}
public List<String> selectData() throws SQLException
{
	try {
		state=connection.createStatement();
	
	
	String query="select * from dell";
	ResultSet resultset = state.executeQuery(query);
	while(resultset.next())
	{
	String string = resultset.getString(2);
	//System.out.println("database name" +str);
	
	result.add(string);
	
	
	
	}
	}catch(NullPointerException e)
	{
		e.getStackTrace();
		
	}
	return result;
	
	
	
}
}
