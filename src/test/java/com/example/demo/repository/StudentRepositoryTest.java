package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	JdbcTemplate template;

	StudentRepository repo;

	@Test
	void testInserrt() {
		assertNotNull(template);

		Student student = new Student(null, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));

		// assertThrows(SQLException.class, repo.insert(student));

	}
//	public animmmous() {
//		return     repo.insert(student);
//		}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		repo = new StudentRepository();
		repo.setJdbcTemplate(template);
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
