package com.project.ExamSeatingArrangement.adminController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ExamSeatingArrangement.pojo.TeacherDetails;
import com.project.ExamSeatingArrangement.services.TeacherService;


@Controller
@RequestMapping("/login")

public class LoginDetails extends HttpServlet {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(value = "/addExamDetailsCSE")
	public String addExamDetailsCSE()
	{
		return "AddExamDetailsCSE";
	}
	
	@GetMapping(value = "/addExamDetailsESE")
	public String addExamDetailsESE()
	{
		return "AddExamDetailsECE";
	}
	
	@GetMapping(value = "/changePasswordPage")
	public String changePassword()
	{
		return "ChangePassword";	
	}
	@GetMapping(value = "/changeStudentPasswordPage")
	public String changeStudentPassword()
	{
		return "StudentChangePassword";	
	}
	
	
	@GetMapping(value = "/newExamDetailsPage")
	public String newExamDetails()
	{
		return "NewExamDetails";	
	}
	
	@GetMapping(value = "/seeExamDetails1Page")
	public String seeExamDetails1()
	{
		return "SeeExamDetails1";	
	}
	
	@GetMapping(value = "/addStudentExamDetailsPage")
	public String addStudentExamDetails()
	{
		return "AddStudentExamDetails";	
	}
	
	
	@GetMapping(value = "/addSubjectPage")
	public String addSubject()
	{
		return "AddSubject";	
	}
	
	
	@GetMapping(value = "/updateSubjectPage")
	public String updateSubject()
	{
		return "UpdateSubject";	
	}
	
	@GetMapping(value = "/addTeacherPage")
	public String addTeacher()
	{
		return "AddTeacher";	
	}
	
	
	@GetMapping(value = "/addNotificationPage")
	public String addNotification()
	{
		return "AddNotification";	
	}
	
	
	@GetMapping(value = "/viewNotificationPage")
	public String viewNotification()
	{
		return "ViewNotification";	
	}
	
	
	@GetMapping(value = "/updatenotifiPage")
	public String updatenotifi()
	{
		return "updatenotifi";	
	}
	
	
	@GetMapping(value = "/viewSeatAllotmentPage")
	public String viewSeatAllotment()
	{
		return "ViewSeatAllotment";	
	}
	
	
	@GetMapping(value = "/verifyStudentPage")
	public String verifyStudent()
	{
		return "VerifyStudent";	
	}
	
	@GetMapping(value = "/seeExamDetailsPage")
	public String seeExamDetails()
	{
		return "SeeExamDetails";	
	}
	
	@GetMapping(value = "/viewSeatAllotment1Page")
	public String ViewSeatAllotment1()
	{
		return "ViewSeatAllotment1";	
	}
	
	
	@GetMapping(value = "/enter")
	public String logging(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Receiving Request - " + request.getParameter("AdminId"));

		int id = Integer.parseInt(request.getParameter("AdminId"));
	    String name=request.getParameter("AdminName");
	    String password=request.getParameter("AdminPassword");	
	    
	    TeacherDetails teacher= new TeacherDetails();
	    teacher.setId(id);
	    
		List<TeacherDetails> details = teacherService.getTeacherDetails(teacher);
		
		String databaseName=null;
		String databasePassword=null;
		
		Iterator<TeacherDetails> teacherIterator = details.iterator();
		
		while(teacherIterator.hasNext()) {
			TeacherDetails databaseDetails=(TeacherDetails)teacherIterator.next();
			databaseName= databaseDetails.getName();
			databasePassword= databaseDetails.getPassword();
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("teacherId", id);
		if(databaseName.equalsIgnoreCase(name) && databasePassword.equalsIgnoreCase(password)) {
			if(id==1) {
			//response.sendRedirect("AdminHomePage.jsp");
			return "AdminHomePage";
			}
			else {		
				//response.sendRedirect("TeacherHomePage.jsp");
				return "TeacherHomePage";
			}
		}
		else {
			System.out.println("Error!");
			return "Error";
		}
		
	}

	
	
}
