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

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.services.StudentService;

@Controller
@RequestMapping("/StudentValidation")
public class StudentValidation extends HttpServlet {
	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public void validateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String studentUsn=request.getParameter("usn");
		String phoneNumber=request.getParameter("phoneNumber");
		String emailId=request.getParameter("emailId");
		String aadharNo=request.getParameter("aadharNumber");
		String password=request.getParameter("password");
		String action = request.getParameter("action");
		System.out.println(action);
		
		System.out.println(name);
		System.out.println(studentUsn);
		System.out.println(phoneNumber);
		System.out.println(emailId);
		System.out.println(aadharNo);
		System.out.println(password);
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(id);
		if(action.equalsIgnoreCase("accept")) {
			studentDetails.setVerified(1);
		}
		else {
			studentDetails.setVerified(2);
		}
		
		studentService.updateStudent(studentDetails);
		
	}
}
