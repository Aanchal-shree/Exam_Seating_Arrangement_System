package com.project.ExamSeatingArrangement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.SubjectDetails;
import com.project.ExamSeatingArrangement.repo.SubjectRepo;
@Service

public class SubjectService {
	@Autowired
	private SubjectRepo subjectRepo;
public void addSubject(SubjectDetails subjectDetails) {
		subjectRepo.save(subjectDetails);
		
	}
	public void updateSubject(SubjectDetails subjectDetails) {
		Optional<SubjectDetails> subjectDetailsOptional = subjectRepo.findById(subjectDetails.getId());
		SubjectDetails sub = null;
		if(subjectDetailsOptional.isPresent())
		{
			sub=subjectDetailsOptional.get();
			sub.setId(subjectDetails.getId());
			sub.setBranch(subjectDetails.getBranch());
			sub.setSem(subjectDetails.getSem());
			sub.setSubjectcode(subjectDetails.getSubjectcode());
			sub.setSubjectname(subjectDetails.getSubjectname());
		}
		subjectRepo.save(sub);
	}
}
