package com.algaworks.festa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Convidado;


public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
	public Convidado findByNome(String nome);
	public Optional<Convidado> findById(Long id);
}


