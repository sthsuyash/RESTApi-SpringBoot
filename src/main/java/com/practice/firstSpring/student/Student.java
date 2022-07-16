/*
 * THIS WILL BE OUR MODEL ('M'VC)
 * */

package com.practice.firstSpring.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity // this is for hibernate
@Table // this is for table in database
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long id;
	private String name, email;
	private LocalDate dob;
	
	// tells no need for you to be in our column in database
	@Transient
	private Integer age;
	
	// default empty constructor
	public Student() {
	}
	
	// parameterized constructor
	public Student(Long id,
	               String name,
	               String email,
	               LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	// constructor without id
	// as database will generate the id for us
	public Student(String name,
	               String email,
	               LocalDate dob) {
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	// getters and setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Integer getAge() {
		return Period.between(dob, LocalDate.now()).getYears();
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	// toString
	/*
	 * Used to get a String object
	 * representing the value of the Number Object.
	 * If the method takes a primitive data type
	 * as an argument, then
	 * the String object representing
	 * the primitive data type value is returned.
	 *
	 * */
	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", dob=" + dob +
				", age=" + age +
				'}';
	}
}
