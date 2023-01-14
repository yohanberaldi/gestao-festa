package com.algaworks.festa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.festa.exception.ConvidadoPresenteJaExiste;
import com.algaworks.festa.model.Presente;
import com.algaworks.festa.repository.PresenteRepository;

@Service
public class PresenteService {
	@Autowired // injeta uma instância na variável em tempo de execução
	private PresenteRepository presenteRepository;

	public Presente getPresenteByConvidadoId(Long id) {
		return presenteRepository.findByIdConvidado(id);
	}

	public Presente savePresente(Presente presente)throws ConvidadoPresenteJaExiste {
		Long idConvidado = presente.getIdConvidado();
		if(getPresenteByConvidadoId(idConvidado) != null) {
			throw new ConvidadoPresenteJaExiste("Convidado já cadastrou presente.");
		}
		
		return presenteRepository.save(presente);
	}

}
