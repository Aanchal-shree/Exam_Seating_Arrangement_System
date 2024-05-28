package com.project.ExamSeatingArrangement.adminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newExam")
public class NewExamDetails extends HttpServlet {
	
	@GetMapping(value="")
	public void newExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Exam Details");
	}


}
