package com.project.ExamSeatingArrangement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.pojo.TeacherDetails;
import com.project.ExamSeatingArrangement.repo.TeacherRepo;
@Service
public class TeacherService {
	@Autowired
	TeacherRepo teacherRepo;
	public void registerTeacher(TeacherDetails teacherDetails) {
		teacherRepo.save(teacherDetails);
	}
	public List getTeacherDetails(TeacherDetails teacherDetails) {
		List<TeacherDetails> details = new ArrayList();
		details.add(teacherRepo.getById(teacherDetails.getId()));
		return details; 
	}
	public void updatePassword(TeacherDetails teacherdetails) {
		Optional<TeacherDetails> teacherDetailsById  = teacherRepo.findById(teacherdetails.getId());
		if(teacherDetailsById.isPresent())
		{
			teacherDetailsById.get().setPassword(teacherdetails.getPassword());
		}
		teacherRepo.save(teacherDetailsById.get());
		}
}
