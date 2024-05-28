package com.project.ExamSeatingArrangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.StudentExamDetails;
@Repository
public interface StudentExamRepo extends JpaRepository < StudentExamDetails, Integer>{

}
