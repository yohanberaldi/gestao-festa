package com.algaworks.festa.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.festa.exception.ConvidadoDataNascimentoExisteException;
import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoMenorDeIdadeException;
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
			convidado = convidadoService.saveConvidado(convidado);
			return "Convidado ID: " + convidado.getId() + " inserido.";
		} catch (ConvidadoNomeJaExisteException | ConvidadoLimiteAcompanhanteException | ConvidadoMenorDeIdadeException | ConvidadoDataNascimentoExisteException e) {
			return e.getMessage();
		}

	}

	@DeleteMapping("/deletar/{id}")
	public String deletarConvidado(@PathVariable Long id) {
		convidadoService.deleteConvidado(id);
		return "Convidado ID: " + id + " apagado.";

	}

	@PutMapping("/update")
	public String atualizarConvidado(@RequestBody Convidado convidado) {
		
		try {
			convidadoService.saveConvidado(convidado);
			return "Convidado ID: " + convidado.getId() + " atualizado.";
		} catch (ConvidadoNomeJaExisteException | ConvidadoLimiteAcompanhanteException | ConvidadoMenorDeIdadeException | ConvidadoDataNascimentoExisteException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping("/idade")
	public int calculateAge(@RequestBody Integer year, Month month, Integer day) {
		LocalDate birthDate = LocalDate.of(year, month, day);
		LocalDate currentDate = LocalDate.now();
		return Period.between(birthDate, currentDate).getYears();
		
	}

}
