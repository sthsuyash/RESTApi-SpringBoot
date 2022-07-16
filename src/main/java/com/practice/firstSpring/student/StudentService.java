package com.practice.firstSpring.student;

/*
 * Service Layer
 * responsible for Business Logic
 * //2nd layer//
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// declaring the given class is service class
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll(); //returns list
	}
	
	// adds new Student to database
	// only if the given email is not in the database
	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken!!");
		}
		studentRepository.save(student);
	}
	
	// deletes the student from database if id found
	public void deleteStudent(Long studentId) {
//		studentRepository.findById(studentId);
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("Student with Id " + studentId + " does not exists.");
		}
		studentRepository.deleteById(studentId);
	}
}