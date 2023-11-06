package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student stud = new Student();

		stud.setNombre(rs.getString("nombre"));
		stud.setApellido(rs.getString("apellido"));

		return stud;
	}

//	@Override
//	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
