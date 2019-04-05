package com.calc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

//import com.service.FileUtility;

public class DatabseUtility {

	Connection getConnection() throws Exception {
		Properties prop = null;
		FileInputStream inStream = null;
		Connection connection=null;
		try {
			prop = new Properties();
			inStream = new FileInputStream("db.properties");
			prop.load(inStream);
			String url = prop.getProperty("Url");
			String user = prop.getProperty("User_name");
			String pass = prop.getProperty("Password");
			String driverclass = prop.getProperty("Driver");
			if (connection == null) {
				// Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName(driverclass);
				connection = DriverManager.getConnection(url, user, pass);
			}
		
			//connection.setAutoCommit(false);
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		return connection;
	}

	public void InserIntoSum( Connection conn, int n1, int n2, int sum) {
		String query = "";
		PreparedStatement ps = null;
	//	FileUtility fu=new FileUtility();
	//	Timestamp ts=new Timestamp(System.currentTimeMillis());
	
		query = "insert into sum_of_numbers (num1,num2,total_sum)values( ?,?,?)";
	
		try {
			ps = conn.prepareStatement(query);
		
			System.out.println(n1); 
			System.out.println(n2); 
			System.out.println(sum); 
			
			ps.setInt(1, n1 );
			ps.setInt(2, n2);
			ps.setInt(3, sum);
		
		
	    int i=	ps.executeUpdate();
		System.out.println(i ); 
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch blockInt
		e.printStackTrace();
	}
	}
	
}
