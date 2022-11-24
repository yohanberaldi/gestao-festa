package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Presente;


public interface PresenteRepository extends JpaRepository<Presente, Long> {
	public Presente findByIdConvidado(Long idConvidado);
}


