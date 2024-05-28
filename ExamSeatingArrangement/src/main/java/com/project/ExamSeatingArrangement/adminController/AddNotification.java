package com.project.ExamSeatingArrangement.adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@RequestMapping("/AddNotification")
public class AddNotification extends HttpServlet {
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping(value="")
	public void addNotificationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		
		String currentDateAndTime=dateFormat.format(date);
		
		String area1=request.getParameter("area");
		
		System.out.println(area1);
		
		NotificationDetails notification=new NotificationDetails();
		notification.setNotification(area1);
		notification.setDate1(currentDateAndTime);
		System.out.println(area1);
		notificationService.addNotification(notification);

	}


}
