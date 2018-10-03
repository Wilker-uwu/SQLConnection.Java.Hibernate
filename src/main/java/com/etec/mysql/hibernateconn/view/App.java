package com.etec.mysql.hibernateconn.view;

import com.etec.mysql.hibernateconn.controller.DaoJpaPessoa;
import com.etec.mysql.hibernateconn.model.Pessoa;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String...args) {
		DaoJpaPessoa.getInstance();
		Pessoa ppl = new Pessoa("Nomeado Meados", "mmMeados");
		DaoJpaPessoa.merge(ppl);
		System.out.println("Hello World!");
	}
}
