package com.example.demo.controller.database;

import org.springframework.stereotype.Component;

//creara para srping un pbjeto en memoria que va a reutilizar
@Component
public class PostgresConnection implements DBConnection {

	public void helloFromPostgres() {
		System.out.println("hola desde el controlador de Postgres");
	}

	@Override
	public void helloFromWhateverDatabase() {
		// TODO Auto-generated method stub
		helloFromPostgres();
	}
}
