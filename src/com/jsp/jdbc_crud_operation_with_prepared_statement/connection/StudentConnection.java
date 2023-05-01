package com.jsp.jdbc_crud_operation_with_prepared_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {

	public static Connection getStudentConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "Priyam";
			
			Connection connection = DriverManager.getConnection(url,user,pass);
			
			if(connection!=null) {
				
				return connection;
			}else {
				System.out.println("Check your url or user or pass");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
