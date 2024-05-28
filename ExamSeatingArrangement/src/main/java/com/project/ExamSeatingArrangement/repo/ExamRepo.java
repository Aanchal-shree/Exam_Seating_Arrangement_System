package com.project.ExamSeatingArrangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.ExamDetails;

@Repository
public interface ExamRepo extends JpaRepository < ExamDetails, Integer> {


}
