package com.murilo.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.murilo.teste.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findByNomeIgnoreCase(@Param("nome") String nome);
	
	List<Cidade> findByEstadoIgnoreCase(@Param("estado") String estado);
	
}
