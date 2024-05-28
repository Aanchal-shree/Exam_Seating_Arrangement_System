package com.project.ExamSeatingArrangement.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.StudentExamDetails;
import com.project.ExamSeatingArrangement.repo.StudentExamRepo;
import com.project.ExamSeatingArrangement.repo.StudentRepo;
import com.project.ExamSeatingArrangement.repo.TeacherRepo;
@Service
public class StudentExamservice {
	@Autowired
	StudentExamRepo studentExamRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
public void addNewStudent(StudentExamDetails studentexamDetails) {
		
		studentExamRepo.save(studentexamDetails);

}
}
