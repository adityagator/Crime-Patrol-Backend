package com.crime.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public final class DBconnection{
	
	private static Connection con;

	public static Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		DBconnection.con = con;
	}

	public DBconnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			setCon(DriverManager.getConnection(  
					"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","rs6","Oracle2019"));
		}catch(Exception e) {
			System.out.println("Error in connecting to database");
		}

	}
}
