package com.algaworks.festa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Convidado;


public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
	public List<Convidado> findByNome(String nome);
	public List<Convidado> findByQuantidadeAcompanhantes(Integer quantidadeAcompanhantes);
}


