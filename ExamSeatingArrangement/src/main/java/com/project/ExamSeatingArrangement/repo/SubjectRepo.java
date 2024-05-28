package com.project.ExamSeatingArrangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.SubjectDetails;
@Repository
public interface SubjectRepo extends JpaRepository < SubjectDetails, Integer>{
	
	@Modifying
	@Query("update SubjectDetails s set s.subjectname= ?1, s.subjectcode= ?2, s.branch= ?3, s.sem= ?4 where id= ?5")
	void setSubjectById(String subjectName, String subjectCode,String branch, String sem ,Integer id);
}
