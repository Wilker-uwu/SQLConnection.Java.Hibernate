package com.etec.mysql.hibernateconn.model;

import javax.persistence.*;

@Entity
@Table(name="tbPessoa")
public class Pessoa {
	
	@Id
	@Column(name="idPessoa")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="pessoaNome", nullable=false)
	private String nome = null;
	
	@Column(name="pessoaUsuario", unique=true, nullable=false)
	private String usuario = null;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}
	
	public Pessoa(final int id, final String nome, final String usuario) throws IllegalArgumentException{
		this(nome,usuario);
		if(id!=-1&&id<1) { throw new IllegalArgumentException("Id should be greater than 1"); }
		this.id = id;
	}
	
	public int getId() { return this.id; }
	public String getNome() { return this.nome; }
	public String getUsuario() { return this.usuario; }
}
