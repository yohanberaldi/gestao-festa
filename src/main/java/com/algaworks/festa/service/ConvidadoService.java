package com.algaworks.festa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.festa.exception.ConvidadoLimiteAcompanhanteException;
import com.algaworks.festa.exception.ConvidadoNomeJaExisteException;
import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	@Autowired // injeta uma instância na variável em tempo de execução
	private ConvidadoRepository convidadoRepository;
	
	public List<Convidado> getConvidados(){
		return convidadoRepository.findAll();
	}
	
	public Convidado insertConvidado(Convidado convidado) throws ConvidadoNomeJaExisteException, ConvidadoLimiteAcompanhanteException {
		List<Convidado> convidados = convidadoRepository.findByNome(convidado.getNome());
		if (!convidados.isEmpty()) {
			throw new ConvidadoNomeJaExisteException(convidados.get(0).getNome()+" já cadastrado.");
		}
		if (convidado.getQuantidadeAcompanhantes() > 3) {
			throw new ConvidadoLimiteAcompanhanteException("Excedeu a quantidade de acompanhantes.");
		}
		
		return convidadoRepository.save(convidado);
	}

}
