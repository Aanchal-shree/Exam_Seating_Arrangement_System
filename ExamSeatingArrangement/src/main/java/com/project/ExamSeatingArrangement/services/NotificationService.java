package com.project.ExamSeatingArrangement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.NotificationDetails;
import com.project.ExamSeatingArrangement.repo.NotificationRepo;
@Service

public class NotificationService {
	@Autowired
	NotificationRepo notificationRepo;
	public void addNotification(NotificationDetails notificationDetails) {
		notificationRepo.save(notificationDetails);

}

public void updateDetails(NotificationDetails notificationDetails) {
	Optional<NotificationDetails> notificationDetailsById = notificationRepo.findById(notificationDetails.getNotificationId());
	NotificationDetails not = null;
	if(notificationDetailsById.isPresent())
	{
		not = notificationDetailsById.get();
		not.setDate1(not.getDate1());
		not.setNotification(notificationDetails.getNotification());
		not.setNotificationId(notificationDetails.getNotificationId());
	}
    notificationRepo.save(not);
}


}
