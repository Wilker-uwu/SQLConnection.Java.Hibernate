package com.etec.mysql.hibernateconn.model;

import javax.persistence.*;

@Entity
@Table(name="tbMensagens")
public class Mensagem {
	
	@Id
	@Column(name="idMensagem")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="idRemetente")
	@JoinColumn(name="idPessoa")
	private int remetente;
	
	@Column(name="mensagemValor", nullable=false)
	private String valor;
	
	public Mensagem() {}
	
	public Mensagem(final int remetente, final String valor) throws IllegalArgumentException {
		if((this.valor = valor.trim()).length() == 0) {
			throw new IllegalArgumentException("Mensagem não pode estar vazia");
		}
	}
	
	public Mensagem(final int id, final int remetente, final String valor) throws IllegalArgumentException {
		this(remetente,valor);
		if(id!=-1&&id<1) { throw new IllegalArgumentException("id não pode ser menor que um."); }
		this.id = id;
	}
	
	public int getId() { return this.id; }
	public int getRemetente() { return this.remetente; }
	public String getValor() { return this.valor; }
}
