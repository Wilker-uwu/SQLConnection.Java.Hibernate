package com.etec.mysql.hibernateconn.view;

import java.util.Calendar;
import java.util.Date;

import com.etec.mysql.hibernateconn.controller.DaoJpaPessoa;
import com.etec.mysql.hibernateconn.model.Pessoa;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String...args) {
		DaoJpaPessoa.getInstance();
		Pessoa ppl = new Pessoa(12, "Nomeado Meados", "mmMeados");
		DaoJpaPessoa.persist(ppl);
		System.out.println("Hello World!");
	}
}
