package com.jsp.jdbc_crud_operation_with_prepared_statement.controller;

import java.util.List;
import java.util.Scanner;
import com.jsp.jdbc_crud_operation_with_prepared_statement.dto.Student;
import com.jsp.jdbc_crud_operation_with_prepared_statement.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService();
		Student student = new Student();
		
		while(true) {
			System.out.println("1.Insert\n2.DeleteStudent\n3.UpdateStudent\n4.DisplayStudent\n5.Exit");
			System.out.println("Give Your own Option");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			//insert case
			case 1:{
				
				System.out.println("Enter the Mobile Id");
				student.setId(sc.nextInt());
				System.out.println("Enter the Student Name");
				student.setName(sc.next());
				System.out.println("Enter the Student RollNo");
				student.setRollno(sc.nextInt());
				System.out.println("Enter the Student Address");
				student.setAddress(sc.next());
				
				studentService.insertStudent(student);
				
			}
			   break;
			
			   //delete case
			case 2:{
				System.out.println("Enter the Id");
				int id = sc.nextInt();
				
				studentService.deleteStudent(id);
			}
			break;
			
			//update case
			case 3:{
				
				System.out.println("Enter the Mobile Id");
				int id = sc.nextInt();
				System.out.println("Enter the Student Name");
				String name = sc.next();
				System.out.println("Enter the Student RollNo");
				int rollno = sc.nextInt();
				System.out.println("Enter the Student Address");
				String address = sc.next();
				
				studentService.updateStudent(id, name, rollno, address);
				
			}
			break;
			
			//display case
			case 4 :{
				
	        List<Student> students = studentService.displayStudent();
				
				for(Student student2 : students) {
					System.out.println("Id :"+student2.getId());
					System.out.println("Name :"+student2.getName());
					System.out.println("RollNo :"+student2.getRollno());
					System.out.println("Address :"+student2.getAddress());
					System.out.println("======================");
				}
			} break;
				
			//exit case
				case 5 : {
					
					System.exit(0);
				} break;
			}
		 }
	 }
		
 }
