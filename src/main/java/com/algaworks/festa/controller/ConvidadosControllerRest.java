package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoNomeJaExisteException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.service.ConvidadoService;

@RestController
@RequestMapping("/convidados/rest")

public class ConvidadosControllerRest {

	@Autowired // injeta uma instância na variável em tempo de execução
	private ConvidadoService convidadoService;

	@GetMapping("/listar")
	public List<Convidado> listarConvidados() {
		return convidadoService.getConvidados();
	}

	@PostMapping("/salvar")
	public String adicionarConvidados(@RequestBody Convidado convidado) {
		
		try {
			convidado=convidadoService.insertConvidado(convidado);
			return "Convidado ID: "+convidado.getId()+" inserido.";
		} catch (ConvidadoNomeJaExisteException | ConvidadoLimiteAcompanhanteException e) {
			return e.getMessage();
		}
		
	}

}
