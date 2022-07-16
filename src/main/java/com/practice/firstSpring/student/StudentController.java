/*
 * THIS CLASS WILL HAVE ALL THE RESOURCES FOR OUT API
 *
 * API layer
 * //1st layer//
 * */

package com.practice.firstSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	//saying this student autowired for us
	public StudentController(StudentService studentService) {
//		this.studentService = new StudentService(); //->don't use this
		// use dependency injection
		this.studentService = studentService;
	}
	
	// makes this class to serve REST end points
	@GetMapping
	// list transfers data as JSON
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
}
