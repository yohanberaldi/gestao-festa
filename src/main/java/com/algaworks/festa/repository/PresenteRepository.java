package com.algaworks.festa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Presente;


public interface PresenteRepository extends JpaRepository<Presente, Long> {
	public Presente findByIdConvidado(Long idConvidado);
	public List<Presente> findByNome(String nome);
}


