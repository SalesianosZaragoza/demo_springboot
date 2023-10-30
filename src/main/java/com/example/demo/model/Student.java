package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Student {
	private String nombre;
	private String apellido;
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}

}
