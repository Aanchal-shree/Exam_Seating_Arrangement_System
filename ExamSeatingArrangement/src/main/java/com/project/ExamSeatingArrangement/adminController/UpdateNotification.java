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

import com.project.ExamSeatingArrangement.pojo.NotificationDetails;
import com.project.ExamSeatingArrangement.services.NotificationService;


@Controller
@RequestMapping("/UpdateNotification")
public class UpdateNotification extends HttpServlet {
	
	@Autowired
	NotificationService notificationService;

	@GetMapping(value="")
	public void updateNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 	String notification1=request.getParameter("notification");
		 	String notificationId1=request.getParameter("notificationId");
		 	int notificationid=Integer.parseInt(notificationId1);
		 	
		 	
			NotificationDetails  notificationdetails =new NotificationDetails();
			notificationdetails.setNotification(notification1);
			notificationdetails.setNotificationId(notificationid);
			
			NotificationService notify=new NotificationService();
			notificationService.updateDetails(notificationdetails);
			
		
	}

}
