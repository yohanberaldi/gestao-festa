package com.algaworks.festa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Presente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //marca essa propriedade como representante da chave primária do banco
	@GeneratedValue(generator = "increment") //pede ao Hibernate que gere o identificador
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private Long idConvidado;
	
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdConvidado() {
		return idConvidado;
	}

	public void setIdConvidado(Long idConvidado) {
		this.idConvidado = idConvidado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
