package com.as;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseTest {

	@Test
	public void databaseTest() throws ClassNotFoundException, SQLException {
		// This line call the Driver... Is driver available in pom.xml
		Class.forName("com.mysql.jdbc.Driver");
		// Does that String specify your database, port number and all, confirm
		// username, password
		Connection dbconn =
				DriverManager.getConnection("jdbc://mysql//localhost/sa");
		Statement stmt = dbconn.createStatement();
		// SQL correct? Do they refer to actual columns with the specified table
		// SQL: Select name, age from person
		ResultSet rs =
				stmt.executeQuery("select username, password from user ");
		while (rs.next()) {
			// These have to belong to fields and getString needs to be
			// exchanged with proper satatype
			String username = rs.getString(1);
			String password = rs.getString(2);
			// System out refer to actual fields or variables
			System.out.println("User " + " : password " + password);
		}
		rs.close();
		stmt.close();
		dbconn.close();

	}
}
