package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.model.Student;
import com.example.demo.model.StudentRowMapper;

@Controller
public class StudentController {
	@Autowired
	DBConnection db;

	@Autowired
	JdbcTemplate jdbcTemplate;

	// localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante(Student student, Model model) {
		System.out.println("name:" + student.getNombre());
		jdbcTemplate.update(
				"insert into students(nombre,apellido) values (?,?)",
				student.getNombre(), student.getApellido()

				);
		
				List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
				for (Student stud : lista) {
					System.out.println(stud.getNombre() + " " + stud.getApellido());
				}

				model.addAttribute("estudiantes", lista);

		return "fin";
	}

	// localhost:8081/updateStudent/gorka
	@RequestMapping("/updateStudent/{nombre}")
	public String actualizarEstudiante(@PathVariable String nombre, Model model) {
		Student stud = jdbcTemplate.queryForObject(
				"SELECT * FROM STUDENTS WHERE nombre=?", 
				new StudentRowMapper(), new Object[] { nombre });
		System.out.println(stud.getNombre() + " " + stud.getApellido());
		return "fin";
	}
	
	
	
	
}
