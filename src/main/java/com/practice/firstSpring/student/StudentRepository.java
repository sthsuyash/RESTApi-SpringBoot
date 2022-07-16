package com.practice.firstSpring.student;

// naming convention
// working with JPA
// database layer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// annotation 'repository' because this interface is responsible for data access
@Repository
public interface StudentRepository
		extends JpaRepository<Student, Long> {
	
	// SELECT * FROM student WHERE email=?
	@Query("SELECT s FROM Student s WHERE s.email=?1") // JPQL
	Optional<Student> findStudentByEmail(String email);
	
}
