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

import com.project.ExamSeatingArrangement.pojo.SubjectDetails;
import com.project.ExamSeatingArrangement.services.SubjectService;

@Controller
@RequestMapping("/UpdateSubject")
public class UpdateSubjectDetails extends HttpServlet {
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("")
	protected void updateSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String subjectName = request.getParameter("subjectname");
		String subjectcode = request.getParameter("subjectcode");
		String branch = request.getParameter("branch");
		String sem = request.getParameter("sem");
		
		SubjectDetails subject1 = new SubjectDetails();
		subject1.setId(id);
		subject1.setSubjectname(subjectName);
		subject1.setSubjectcode(subjectcode);
		subject1.setBranch(branch);
		subject1.setSem(sem);
		
		subjectService.updateSubject(subject1);
		
	}
}
