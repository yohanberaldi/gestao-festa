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
	public RedirectView salvar(Convidado convidado, RedirectAttributes attributes){
		String mensagem;
		try {
			convidadoService.insertConvidado(convidado);
			mensagem = "Inserido com sucesso.";
		} catch (ConvidadoNomeJaExisteException e) {
			mensagem = e.getMessage();
		} catch (ConvidadoLimiteAcompanhanteException e) {
			mensagem = e.getMessage();
		}
	
		attributes.addAttribute("mensagem", mensagem);
		return new RedirectView("/convidados/listar");
	}

}
