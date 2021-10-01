package com.cg.kanban.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			con =DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  

			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
			return con;
		}
	}
}
