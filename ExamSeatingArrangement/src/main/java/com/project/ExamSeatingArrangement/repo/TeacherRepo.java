package com.project.ExamSeatingArrangement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.TeacherDetails;
@Repository
public interface TeacherRepo extends JpaRepository < TeacherDetails, Integer>{
	@Modifying
	@Query("select s from TeacherDetails s  where s.id = ?1")
	List getTeacherDetailsById(Integer id);
	
	@Modifying
	@Query("update TeacherDetails s set s.password = ?1 where s.id = ?2")
	void setPasswordById(String password, Integer id);
}
