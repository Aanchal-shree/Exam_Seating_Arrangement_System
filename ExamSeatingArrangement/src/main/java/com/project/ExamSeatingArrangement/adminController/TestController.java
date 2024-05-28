package com.project.ExamSeatingArrangement.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TestController {
	@GetMapping(value="")
	public String hello(ModelMap Model) {
	    return "MainPage";
	}
	@GetMapping(value = "/teacherLogin")
	public String teacherLogin()
	{
		return "TeacherLogin";	
	}
	@GetMapping(value = "/adminLogin")
	public String adminLogin()
	{
		return "AdminLogin";	
	}
	@GetMapping(value = "/studentLoginPage")
	public String studentLogin()
	{
		return "StudentLogin";	
	}
	@GetMapping(value = "/registerStud")
	public String registerStudent()
	{
		return "RegisterNewStudent";	
	}
	@GetMapping(value = "/adminHomePage")
	public String adminHomePage()
	{
		return "AdminHomePage";	
	}
	@GetMapping(value = "/teacherHomePage")
	public String teacherHomePage()
	{
		return "TeacherHomePage";	
	}
	@GetMapping(value = "/studentHomePage")
	public String studentHomePage()
	{
		return "StudentHomePage";
	}
	@GetMapping(value = "/displayAllotmentPage")
	public String displayAllotmentPage()
	{
		return "DisplayAllotment";
	}
	@GetMapping(value = "/displayAllotment2Page")
	public String displayAllotment2Page()
	{
		return "DisplayAllotment2";
	}
	@GetMapping(value = "/displayAllotment1Page")
	public String displayAllotment1Page()
	{
		return "DisplayAllotment1";
	}
	@GetMapping(value = "/viewExamDetailsPage")
	public String viewExamDetailsPage()
	{
		return "ViewExamDetails";
	}
	@GetMapping(value = "/viewExamDetails1Page")
	public String viewExamDetails1Page()
	{
		return "ViewExamDetails1";
	}
	@GetMapping(value = "/viewExamDetails2Page")
	public String viewExamDetails2Page()
	{
		return "ViewExamDetails2";
	}
	@GetMapping(value = "/mySeatAllotmentPage")
	public String mySeatAllotmentPage()
	{
		return "MySeatAllotment";
	}
	@GetMapping(value = "/updateNotificationPage")
	public String updateNotificationPage()
	{
		return "UpdateNotification";
	}
	
	
}
