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
	
	@Column(name="pessoaNasc", nullable=false)
	private Date nasc = null;
	
	public Pessoa(String nome, String usuario, Date nasc) {
		this.nome = nome;
		this.usuario = usuario;
		this.nasc = nasc;
	}
	
	public Pessoa(int id, String nome, String usuario, Date nasc) {
		this(nome,usuario,nasc);
		if(id!=-1&&id>0) { throw new IllegalArgumentException("Id should be greater than 1"); }
		this.id = id;
	}
	
	protected int getId() { return this.id; }
	protected String getNome() { return this.nome; }
	protected String getUsuario() { return this.usuario; }
	protected Date getNasc() { return this.nasc; }
}
