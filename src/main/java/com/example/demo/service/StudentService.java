package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentRowMapper;

@Service // component, repository esas tres anotaciones hacen que solo se cree un objeto
			// de esta clase y se vaya usando conforme hace falta
public class StudentService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> insertStudent(Student student) {
		System.out.println("name:" + student.getNombre());
		if (student.getId() == null) {
			jdbcTemplate.update("insert into students(nombre, apellido) values(?, ?);", student.getNombre(),
					student.getApellido());
		} else {
			// si existe un update
			jdbcTemplate.update("UPDATE students SET nombre = ?, apellido = ? WHERE id=?;", student.getNombre(),
					student.getApellido(), student.getId());
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}

	public Student updateStudent(Integer id) {
		Student stud = jdbcTemplate.queryForObject("SELECT * FROM STUDENTS WHERE id=?", new StudentRowMapper(),
				new Object[] { id });

		System.out.println(stud.getNombre() + " " + stud.getApellido());
		return stud;
	}

	public List<Student> deleteStudent(Integer id) {
		jdbcTemplate.update("DELETE FROM STUDENTS WHERE id=?", new Object[] { id });

		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
		return lista;
	}

	public List<Student> searchStudent(String userInput) {
		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ? OR apellido = ?",
				new StudentRowMapper(), userInput, userInput);
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}

	public Student searchById(long id) {
		Student stud = jdbcTemplate.queryForObject("select * from STUDENTS where id=?",
				new BeanPropertyRowMapper<Student>(Student.class), new Object[] { id });
		return stud;
	}
}
