package com.project.ExamSeatingArrangement.studentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.services.StudentService;

@Controller
@RequestMapping("/RegisterNewStudent")
public class RegisterNewStudent {
    
	@Autowired
    StudentService studentService;
	
	@GetMapping(value = "")
public String registerStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("studentName");
		String studentUsn=request.getParameter("studentUsn");
		String phoneNumber=request.getParameter("studentPhoneNumber");
		String emailId=request.getParameter("studentEmailId");
		String aadharNo=request.getParameter("studentAadharNo");
		String password=request.getParameter("studentPassword");
		System.out.println(name);
		System.out.println(studentUsn);
		System.out.println(phoneNumber);
		System.out.println(emailId);
		System.out.println(aadharNo);
		System.out.println(password);
		
		StudentDetails studentDetails=new StudentDetails();
		studentDetails.setName(name);
		studentDetails.setUsn(studentUsn);
		studentDetails.setPhoneNumber(phoneNumber);
		studentDetails.setEmailId(emailId);
		studentDetails.setAadharNumber(aadharNo);
		studentDetails.setPassword(password);
		
		
		studentService.registerNewStudent(studentDetails);
		return "MainPage";
		
		
	}


}
