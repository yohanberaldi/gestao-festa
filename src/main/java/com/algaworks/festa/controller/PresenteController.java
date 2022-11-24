package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoMenorDeIdadeException;
import com.algaworks.festa.exception.ConvidadoNomeJaExisteException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.model.Presente;
import com.algaworks.festa.service.ConvidadoService;
import com.algaworks.festa.service.PresenteService;

@Controller
@RequestMapping("/presente")
public class PresenteController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@Autowired
	private PresenteService presenteService;

	@GetMapping("/adicionar") // o método irá responder a requisição HTTP do tipo GET
	public ModelAndView listar(String mensagem) {
		ModelAndView modelAndView = new ModelAndView("presente-form"); // o construtor recebe o nome da view
		modelAndView.addObject("convidados", convidadoService.getConvidados()); // adiciona objetos para a view
		modelAndView.addObject(new Presente());
	
		return modelAndView;
	}
	
	@PostMapping("/salvar")
	public RedirectView salvar(Presente presente, RedirectAttributes attributes) {
		String mensagem;
		
		mensagem = "Inserido com sucesso.";

		attributes.addAttribute("mensagem", mensagem);
		return new RedirectView("/convidados/listar");
	}

}
