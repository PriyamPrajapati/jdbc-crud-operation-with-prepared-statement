package com.jsp.jdbc_crud_operation_with_prepared_statement.service;

import java.util.List;
import com.jsp.jdbc_crud_operation_with_prepared_statement.dao.StudentDao;
import com.jsp.jdbc_crud_operation_with_prepared_statement.dto.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();
	
	//insert method for student
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}
	
	//delete method for student
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}
	
	//update method for student
	public void updateStudent(int id, String name, int rollno, String address)
	{
		studentDao.updateStudent(id, name, rollno, address);
	}
	
	//display method for student
	public List<Student> displayStudent() {
		List<Student> students = studentDao.displayStudent();
		
		return students;
	}
	

}
