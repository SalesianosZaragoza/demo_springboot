package com.example.demo.controller.database;

import org.springframework.stereotype.Component;

//creara para srping un pbjeto en memoria que va a reutilizar
@Component(value = "h2")
public class H2Connection implements DBConnection {

	public void helloFromH2() {
		System.out.println("hola desde el controlador de H2");
	}

	@Override
	public void helloFromWhateverDatabase() {
		helloFromH2();
	}
}
