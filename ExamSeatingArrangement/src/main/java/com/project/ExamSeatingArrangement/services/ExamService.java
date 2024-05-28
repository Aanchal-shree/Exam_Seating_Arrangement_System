package com.project.ExamSeatingArrangement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.ExamDetails;
import com.project.ExamSeatingArrangement.repo.ExamRepo;

@Service
public class ExamService {
	@Autowired
	ExamRepo examRepo;
public void addExam(ExamDetails examDetails) {
		
		examRepo.save(examDetails);

}

}
