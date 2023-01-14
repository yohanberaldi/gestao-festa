package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.algaworks.festa.exception.ConvidadoDataNascimentoExisteException;
import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoMenorDeIdadeException;
import com.algaworks.festa.exception.ConvidadoNomeJaExisteException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.service.ConvidadoService;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private ConvidadoService convidadoService;

	@GetMapping("/listar") // o método irá responder a requisição HTTP do tipo GET
	public ModelAndView listar(String mensagem) {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados"); // o construtor recebe o nome da view
		modelAndView.addObject("convidados", convidadoService.getConvidados()); // adiciona objetos para a view
		modelAndView.addObject(new Convidado());
		modelAndView.addObject("mensagem", mensagem);

		return modelAndView;
	}

	@PostMapping("/salvar")
	public RedirectView salvar(Convidado convidado, RedirectAttributes attributes) {
		String mensagem;
		try {
			convidadoService.saveConvidado(convidado);
			mensagem = "Inserido com sucesso.";
		
		} catch (ConvidadoNomeJaExisteException | ConvidadoLimiteAcompanhanteException | ConvidadoMenorDeIdadeException | ConvidadoDataNascimentoExisteException e) {
			mensagem = e.getMessage();
		}

		attributes.addAttribute("mensagem", mensagem);
		return new RedirectView("/convidados/listar");
	}

	@PostMapping("/deletar/{id}")
	public String deletar(@PathVariable Long id, RedirectAttributes attributes) {
		String mensagem;

		convidadoService.deleteConvidado(id);
		mensagem = "Convidado ID: " + id + " apagado com sucesso.";

		attributes.addAttribute("mensagem", mensagem);
		return "redirect:/convidados/listar";
	}

	@GetMapping("/formularioUpdate")
	public ModelAndView update(String mensagem, @RequestParam Long idConvidado) {
		ModelAndView modelAndView = new ModelAndView("update-form"); // o construtor recebe o nome da view
		Convidado convidado = convidadoService.getConvidadoById(idConvidado);
		modelAndView.addObject("convidado", convidado);
		modelAndView.addObject("mensagem", mensagem);

		return modelAndView;
	}

	@PostMapping("/updateConvidado")
	public RedirectView updateConvidado(Convidado convidado, RedirectAttributes attributes) {
		String mensagem;
		try {
			convidadoService.saveConvidado(convidado);
			mensagem = "Atualizado com sucesso.";
		} catch (ConvidadoNomeJaExisteException | ConvidadoLimiteAcompanhanteException | ConvidadoMenorDeIdadeException | ConvidadoDataNascimentoExisteException e) {
			mensagem = e.getMessage();
		}

		attributes.addAttribute("mensagem", mensagem);
		return new RedirectView("/convidados/listar");
	}

}
