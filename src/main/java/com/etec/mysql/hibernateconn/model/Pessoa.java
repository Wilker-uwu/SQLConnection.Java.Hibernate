package com.etec.mysql.hibernateconn.model;

import java.util.Date;

import javax.persistence.*;

/**
 * 'Person' class example
 */
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
	
	public Pessoa(String nome, String usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}
	
	public Pessoa(int id, String nome, String usuario) {
		this(nome,usuario);
		if(id!=-1&&id>0) { throw new IllegalArgumentException("Id should be greater than 1"); }
		this.id = id;
	}
	
	public int getId() { return this.id; }
	public String getNome() { return this.nome; }
	public String getUsuario() { return this.usuario; }
}
