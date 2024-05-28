package com.project.ExamSeatingArrangement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
@Repository
public interface StudentRepo extends JpaRepository < StudentDetails, Integer>{
	
	@Modifying
	@Query("update StudentDetails s set s.verified = ?1 where s.id = ?2")
	void setStudentVerificationById(Integer verified, Integer id);
	
	@Modifying
	@Query("select s from StudentDetails s  where s.name = ?1")
	List getStudentDetailsByName(String name);
	
	@Modifying
	@Query("update StudentDetails s set s.password = ?1 where s.id = ?2")
	void setPasswordById(String password, Integer id);
}

