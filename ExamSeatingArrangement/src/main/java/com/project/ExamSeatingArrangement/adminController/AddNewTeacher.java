package com.project.ExamSeatingArrangement.adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ExamSeatingArrangement.pojo.TeacherDetails;
import com.project.ExamSeatingArrangement.services.TeacherService;

@Controller
@RequestMapping("/addTeacher")
public class AddNewTeacher extends HttpServlet {

	@Autowired
	TeacherService teacherService;
	
	@GetMapping(value ="")
	public void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  String teacherName=request.getParameter("TeacherName"); String
		  PhoneNumber=request.getParameter("PhoneNumber"); String
		  Password=request.getParameter("Password"); 
		 
		System.out.println(teacherName);
		System.out.println(PhoneNumber);
		System.out.println(Password);
		
		TeacherDetails teacherDetails1 = new TeacherDetails();
		teacherDetails1.setName(teacherName);
		teacherDetails1.setPhoneNumber(PhoneNumber);
		teacherDetails1.setPassword(Password);
		
		teacherService.registerTeacher(teacherDetails1);
		
		
	}
}
