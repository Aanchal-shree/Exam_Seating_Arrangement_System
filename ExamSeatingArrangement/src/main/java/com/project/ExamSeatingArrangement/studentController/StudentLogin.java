package com.project.ExamSeatingArrangement.studentController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.services.StudentService;

@Controller
@RequestMapping("/studentLogin")
public class StudentLogin extends HttpServlet {
    
	@Autowired
    StudentService studentService;
	@GetMapping(value="/studentHomePage")
	public String studentHomePage()
	{
		return "StudentHomePage";
	}
	@GetMapping(value = "/changeStudentPassword")
	public String changeStudentPassword()
	{
		return "StudentChangePassword";
	}
	
	@GetMapping(value = "/seeMySeatAllotment")
	public String seeMySeatAllotment()
	{
		return "SeeMySeatAllotment";
	}
	
	@GetMapping(value = "/seeAllStudentsSeatAllotment")
	public String seeAllStudentsSeatAllotment()
	{
		return "SeeAllStudentsSeatAllotment";
	}
	
	@GetMapping(value = "/seeExamDetailForStudent")
	public String seeExamDetailForStudent()
	{
		return "SeeExamDetails2";
	}
	
	@GetMapping(value = "/seeNotifications")
	public String seeNotifications()
	{
		return "SeeNotification";
	}
	
	@GetMapping(value  = "/allStudentLogin")
	public String logging(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entering the Student Login");

		String name = request.getParameter("studentName");
		String password = request.getParameter("password");
		System.out.println("Student Details - " + name);

		StudentDetails student = new StudentDetails();
		student.setName(name);

		List<StudentDetails> student1 = studentService.getStudentDetails(student);
		System.out.println(student1.isEmpty());
		
		
		String databaseName = null;
		String databasePassword = null;
		int id=0;
		int verified=3;
		PrintWriter out = response.getWriter();
		Iterator<StudentDetails> studentIterator = student1.iterator();
		
		while (studentIterator.hasNext()) {
			StudentDetails databaseDetails = (StudentDetails) studentIterator.next();
			databaseName = databaseDetails.getName();
			databasePassword = databaseDetails.getPassword();
			id = databaseDetails.getId();
			verified = databaseDetails.getVerified();
		}

		if(verified==1) {
		HttpSession session=request.getSession(true);
		session.setAttribute("studentId", id);
		if (databaseName.equalsIgnoreCase(name) && databasePassword.equalsIgnoreCase(password)) {
			
			//response.sendRedirect("StudentHomePage.jsp");
			return "StudentHomePage";
		} else {
			System.out.println("Error!");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username or password is wrong');");
			out.println("location='MainPage.jsp';");
			out.println("</script>");
			return "Error! Username or password is wrong";

		}
		}
		else if(verified==0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Verification pending. Try again later');");
			out.println("location='MainPage.jsp';");
			out.println("</script>");
			return "Error! Verification pending. Try again later";

		}
		else if(verified==2) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration rejected');");
			out.println("location='MainPage.jsp';");
			out.println("</script>");
			return "Error! Registration rejected";

		}
		return "";
		}


}
