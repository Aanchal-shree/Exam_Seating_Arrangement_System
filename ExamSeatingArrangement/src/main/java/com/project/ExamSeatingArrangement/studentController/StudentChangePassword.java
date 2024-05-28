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

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.services.StudentService;

@Controller
@RequestMapping("/StudentChangePassword")
public class StudentChangePassword extends HttpServlet {
	@Autowired
    StudentService studentService;
	
	@GetMapping("")
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int studentId = (Integer) session.getAttribute("studentId");
		System.out.println(studentId);
		String OldPassword = request.getParameter("oldPassword");
		String NewPassword = request.getParameter("newPassword");
		String ConfirmPassword = request.getParameter("confirmPassword");

		StudentDetails student = new StudentDetails();
		student.setId(studentId);
		System.out.println(OldPassword);

		List<StudentDetails> details = studentService.getStudentDetails(student);
		System.out.println(details.isEmpty());

		String databasePassword = null;

		Iterator<StudentDetails> studentIterator = details.iterator();

		while (studentIterator.hasNext()) {
			StudentDetails databaseDetails = (StudentDetails) studentIterator.next();
			databasePassword = databaseDetails.getPassword();
		}
		if (OldPassword.equalsIgnoreCase(databasePassword)) {
			if (NewPassword.equalsIgnoreCase(ConfirmPassword)) {
				StudentDetails student1 = new StudentDetails();
				student1.setId(studentId);
				student1.setPassword(NewPassword);
				studentService.updatePassword(student1);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password updated');");
				out.println("location='StudentHomePage.jsp';");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Re-entered password is wrong');");
				out.println("location='StudentChangePassword.jsp';");
				out.println("</script>");
			}

		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password is wrong');");
			out.println("location='StudentChangePassword.jsp';");
			out.println("</script>");
		}

	}
}
