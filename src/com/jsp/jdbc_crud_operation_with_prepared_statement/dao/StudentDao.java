package com.jsp.jdbc_crud_operation_with_prepared_statement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jsp.jdbc_crud_operation_with_prepared_statement.connection.StudentConnection;
import com.jsp.jdbc_crud_operation_with_prepared_statement.dto.Student;

public class StudentDao {
	
	Connection connection = null;

	//insert method for student
	public void insertStudent(Student student) {
		
		 connection = StudentConnection.getStudentConnection();
		
		String insertStudnetQuery = "insert into student values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertStudnetQuery);
			
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getRollno());
			preparedStatement.setString(4, student.getAddress());
			
			preparedStatement.execute();
			
			System.out.println("Data Inserted...");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//delete method for student
	public void deleteStudent(int id) {
		
		 connection = StudentConnection.getStudentConnection();
		
		String deleteStudentQuery = "delete from student where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentQuery);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("Data Deleted Successfully");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//update method for student
	public void updateStudent(int id, String name, int rollno, String address) {
		
		 connection = StudentConnection.getStudentConnection();
		
		
		String updateStudentQuery = "update student set name=?,rollno=?,address=? where id=?";
		
				
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(updateStudentQuery);
				
				preparedStatement.setInt(4, id);
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, rollno);
				preparedStatement.setString(3, address);
				
				
				preparedStatement.executeUpdate();
				
				System.out.println("Data Updated");
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	
	//display method for student
	public List<Student> displayStudent(){
		
	 connection = StudentConnection.getStudentConnection();
	
	String displayStudentQuery = "select * from student";
	
	try {
		
		PreparedStatement preparedStatement = connection.prepareStatement(displayStudentQuery);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<Student> students = new ArrayList<Student>();
	
		while(resultSet.next()) {
			
			Student student = new Student();
			
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setRollno(resultSet.getInt("rollno"));
			student.setAddress(resultSet.getString("address"));
			
			students.add(student);
			
		}
		return students;
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
}
