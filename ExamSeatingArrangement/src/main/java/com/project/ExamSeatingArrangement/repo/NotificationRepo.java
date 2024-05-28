package com.project.ExamSeatingArrangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.NotificationDetails;
@Repository
public interface NotificationRepo extends JpaRepository < NotificationDetails, Integer>{
	@Modifying
	@Query("update NotificationDetails n set n.notification = ?1 where n.notificationId = ?2")
	void setNotificationById(String notification, Integer notificationId);


}
