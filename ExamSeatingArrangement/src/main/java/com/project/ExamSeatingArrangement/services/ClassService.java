package com.project.ExamSeatingArrangement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.ClassDetails;
import com.project.ExamSeatingArrangement.repo.ClassRepo;
@Service
public class ClassService {
	@Autowired
	ClassRepo classRepo;
public void addClass(ClassDetails classDetails) {
		classRepo.save(classDetails);
}
}
