package com.example.demo.controller.database;

import org.springframework.stereotype.Component;

//creara para srping un pbjeto en memoria que va a reutilizar
@Component
public class H2Connection {

	public void helloFromH2() {
		System.out.println("hola desde el controlador de H2");
	}
}
