package com.RealCitadel.genericFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;


/**
 * this class contains all common action related to database
 * @author Jyothi
 *
 */
public class DatabaseUtility{
    Connection connection;
	Statement statement;
	/**
	 * this method is used to open the database connection and initialize the connection statement
	 * @param dBUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public DatabaseUtility(String dBUrl,String dbUserName,String dbPassword) throws SQLException {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
		
		connection=DriverManager.getConnection(dBUrl,dbUserName,dbPassword);
		
		statement=connection.createStatement();
	}
	/**
	 * this method is used to fecth the data from database to do the DQL action on database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String>getDataFromDataBase(String query,String columnName) throws SQLException{
	ArrayList<String> list=new ArrayList<>();
	ResultSet result=statement.executeQuery(query);
	while(result.next()) 
	{
		list.add(result.getString(columnName));
	}
	
	return list;
	
		
	}
	/**
	 * 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
public boolean  ValidateDataInDatabase(String query,String columnName,String expectedData) throws SQLException
{
	ArrayList<String> list=getDataFromDataBase(query,columnName);
	boolean flag = false;
	for(String actualData:list)
	{
		if(actualData.equals(expectedData))
		{
			flag=true;
			break;
			
		}
	}
	return flag;
}
/**
 * this method is used to update the data in database 
 * @param query
 * @throws SQLException
 */
public void setDataInDataBase(String query) throws SQLException
{
	int result = statement.executeUpdate(query);
	if(result>=1)
	{
	System.out.println("Data entered/modified succesfully");
	}
}
/**
 * this method is used to close the database connection
 */
public void  closeDBconnection() {
	try {
	connection.close();
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("while closing the DataBase connection get the exception");
	}
	
}
}


	