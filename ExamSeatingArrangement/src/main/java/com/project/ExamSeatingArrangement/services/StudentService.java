package com.project.ExamSeatingArrangement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExamSeatingArrangement.pojo.StudentDetails;
import com.project.ExamSeatingArrangement.repo.StudentExamRepo;
import com.project.ExamSeatingArrangement.repo.StudentRepo;
import com.project.ExamSeatingArrangement.repo.TeacherRepo;

@Service
public class StudentService {
	@Autowired
	StudentExamRepo studentExamRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	TeacherRepo teacherRepo;
	public void registerNewStudent(StudentDetails studentsDetails) {
		
	studentRepo.save(studentsDetails);
	}
	
	public void updateStudent(StudentDetails studentDetails) {
		Optional<StudentDetails> sdOptional = studentRepo.findById(studentDetails.getId());
		StudentDetails sd = null;
		if(sdOptional.isPresent())
		{
			sd = sdOptional.get();
			sd.setVerified(studentDetails.getVerified());
			
		}
		studentRepo.save(sd);
	}
	
public List getStudentDetails(StudentDetails studentDetails) {
		System.out.println("Name received - "+studentDetails.getName());	
		List<StudentDetails> students =  studentRepo.getStudentDetailsByName(studentDetails.getName());
		for(int i =0;i<students.size();i++)
		{
			System.out.println("Student Name - "+students.get(i).getName());
		}
		return students;
		
	}

	public void updatePassword(StudentDetails studentDetails) {
		Optional<StudentDetails> sdOptional = studentRepo.findById(studentDetails.getId());
		StudentDetails sd = null;
		if(sdOptional.isPresent())
		{
			sd = sdOptional.get();
			sd.setPassword(studentDetails.getPassword());
			
		}
		studentRepo.save(sd);

	}
}

