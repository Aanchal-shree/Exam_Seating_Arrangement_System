package com.project.ExamSeatingArrangement.adminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Update")
public class UpdateSubject extends HttpServlet {
	
	@GetMapping(value = "")
	public String updateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("subjectID"));
		System.out.println(id);
		HttpSession session=request.getSession(true);
		session.setAttribute("subjectId", id);
	    return "SubjectDetailsUpdate";
	}
}
