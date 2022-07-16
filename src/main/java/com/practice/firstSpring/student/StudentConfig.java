package com.practice.firstSpring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.MARCH;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student suyash = new Student(
					"Suyash",
					"suyash@gmail.com",
					LocalDate.of(2005, MARCH, 5)
			);
			
			Student alex = new Student(
					"Alex",
					"alex@gmail.com",
					LocalDate.of(2003, APRIL, 5)
			);
			
			repository.saveAll(
					List.of(suyash, alex)
			);
			
		};
	}
}
