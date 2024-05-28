package com.project.ExamSeatingArrangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ExamSeatingArrangement.pojo.ClassDetails;
@Repository
public interface ClassRepo extends JpaRepository < ClassDetails, Integer> {

}
