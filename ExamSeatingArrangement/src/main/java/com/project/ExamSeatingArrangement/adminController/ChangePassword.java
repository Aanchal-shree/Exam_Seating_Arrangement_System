package com.project.ExamSeatingArrangement.adminController;

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

import com.project.ExamSeatingArrangement.pojo.TeacherDetails;
import com.project.ExamSeatingArrangement.services.TeacherService;

@Controller
@RequestMapping("/change")
public class ChangePassword extends HttpServlet {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(value = "")
	public String changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherId = Integer.parseInt(request.getParameter("id"));
		String OldPassword = request.getParameter("Old");
		String NewPassword = request.getParameter("New1");
		String ConfirmPassword = request.getParameter("New2");

		TeacherDetails teacher = new TeacherDetails();
		teacher.setId(teacherId);

		List<TeacherDetails> details = teacherService.getTeacherDetails(teacher);

		String databasePassword = null;

		Iterator<TeacherDetails> teacherIterator = details.iterator();
		PrintWriter out = response.getWriter();

		while (teacherIterator.hasNext()) {
			TeacherDetails databaseDetails = (TeacherDetails) teacherIterator.next();
			databasePassword = databaseDetails.getPassword();
		}
		if (OldPassword.equalsIgnoreCase(databasePassword)) {
			if (NewPassword.equalsIgnoreCase(ConfirmPassword)) {
				TeacherDetails teacher1 = new TeacherDetails();
				teacher1.setId(teacherId);
				teacher1.setPassword(NewPassword);
				teacherService.updatePassword(teacher1);
				if (teacherId == 1) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Password changed');");
					out.println("location='AdminHomePage.jsp';");
					out.println("</script>");
					return "AdminHomePage";
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Password changed');");
					out.println("location='TeacherHomePage.jsp';");
					out.println("</script>");
					return "TeacherHomePage";
				}

			} else {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Re-entered password is wrong');");
					out.println("location='ChangePassword.jsp';");
					out.println("</script>");	
					return "ChangePassword";
			}

		} else {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Wrong Password');");
			out.println("location='ChangePassword.jsp';");
			out.println("</script>");
			return "ChangePassword";

		}

	}

	

}
