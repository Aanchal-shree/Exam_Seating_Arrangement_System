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
@RequestMapping("/subject")
public class AddSubject extends HttpServlet {
	@Autowired
	SubjectService subjectService;
	
	@GetMapping(value="")
	public void addSubjectDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectCode=request.getParameter("SubjectCode");
		String subjectName=request.getParameter("SubjectName");
		String branch=request.getParameter("branch");
		String sem=request.getParameter("semester");
		
		SubjectDetails subjectDetails1 = new SubjectDetails();
		subjectDetails1.setSubjectcode(subjectCode);
		subjectDetails1.setSubjectname(subjectName);
		subjectDetails1.setBranch(branch);
		subjectDetails1.setSem(sem);

		subjectService.addSubject(subjectDetails1);
		

	}


}
