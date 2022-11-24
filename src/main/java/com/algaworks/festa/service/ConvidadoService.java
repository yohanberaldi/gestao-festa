package com.algaworks.festa.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoMenorDeIdadeException;
import com.algaworks.festa.exception.ConvidadoNomeJaExisteException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.model.Presente;
import com.algaworks.festa.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	@Autowired // injeta uma instância na variável em tempo de execução
	private ConvidadoRepository convidadoRepository;
	
	@Autowired
	private PresenteService presenteService;
	
	public List<Convidado> getConvidados() {
		
		List<Convidado> convidados = convidadoRepository.findAll();
		Presente presente;
		
		for (Convidado convidado : convidados) {
			presente = presenteService.getPresenteByConvidadoId(convidado.getId());
			
			if(presente == null) {
				presente = new Presente();
			}
			
			convidado.setPresente(presente);
		}
		
		return convidados;
	}

	public Convidado getConvidadoById(Long id) {
		return convidadoRepository.findById(id).get();
	}

	public Convidado saveConvidado(Convidado convidado) throws ConvidadoNomeJaExisteException, ConvidadoLimiteAcompanhanteException, ConvidadoMenorDeIdadeException {
		Convidado convidadoBanco = convidadoRepository.findByNome(convidado.getNome());
		
		if(!isMaiorDeIdade(convidado.getDataNascimento())){
			throw new ConvidadoMenorDeIdadeException("Convidado é menor de idade!");
		}
		
		if (isConvidadoExisteComIdDiferente(convidado, convidadoBanco)) {
			throw new ConvidadoNomeJaExisteException(convidadoBanco.getNome() + " já cadastrado.");
		}
		
		if (convidado.getQuantidadeAcompanhantes() > 3) {
			throw new ConvidadoLimiteAcompanhanteException("Excedeu a quantidade de acompanhantes permitidos.");
		}
		
		return convidadoRepository.save(convidado);
	}
	
	protected boolean isConvidadoExisteComIdDiferente(Convidado convidado, Convidado convidadoBanco) {
		if(convidadoBanco == null)
			return false;
		
		return convidado.getNome().equals(convidadoBanco.getNome()) && convidado.getId() != convidadoBanco.getId();
	}
	
	protected boolean isMaiorDeIdade(String data) {
		LocalDate dataNascimento = LocalDate.parse(data, DateTimeFormatter.ISO_DATE);
		LocalDate hoje = LocalDate.now();
		return Period.between(dataNascimento, hoje).getYears() >= 18;
	}
	
	public void deleteConvidado(Long id) {
		convidadoRepository.deleteById(id);
	}
	

}
