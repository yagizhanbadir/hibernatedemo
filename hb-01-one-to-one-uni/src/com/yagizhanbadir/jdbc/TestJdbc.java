package com.yagizhanbadir.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		// String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?SSL=false";

		String user = "hbstudent";
		String password = "hbstudent";
		try {

			System.out.println("Connexting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection succesfull!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
