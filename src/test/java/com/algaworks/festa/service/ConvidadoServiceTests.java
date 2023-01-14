package com.algaworks.festa.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.algaworks.festa.model.Convidado;

public class ConvidadoServiceTests {
	
	ConvidadoService convidadoService = new ConvidadoService();
	
	@Test
	void testConvidadoExisteComIdDiferente() {
		long id = 1;
		String nome = "Ricardo";
		
		Convidado convidado = new Convidado();
		convidado.setId(id);
		convidado.setNome(nome);
		
		Convidado convidadoBanco = new Convidado();
		convidadoBanco.setId(id);
		convidadoBanco.setNome(nome);
		
		assertFalse(convidadoService.isConvidadoExisteComIdDiferente(convidado, convidadoBanco));
	}
	
	@Test
	void testConvidadoNaoExisteComIdDiferente() {
		long id = 1;
		long id2 = 2;
		String nome = "Ricardo";
		
		Convidado convidado = new Convidado();
		convidado.setId(id);
		convidado.setNome(nome);
		
		Convidado convidadoBanco = new Convidado();
		convidadoBanco.setId(id2);
		convidadoBanco.setNome(nome);
		
		assertTrue(convidadoService.isConvidadoExisteComIdDiferente(convidado, convidadoBanco));
	}
	
	@Test
	void testConvidadoMaiorDeIdade(){
		assertTrue(convidadoService.isMaiorDeIdade("2004-11-24"));
	}
	
	@Test
	void testConvidadoMenorDeIdade(){
		assertFalse(convidadoService.isMaiorDeIdade("2005-11-25"));
	}
	
}
