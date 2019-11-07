package com.murilo.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.murilo.teste.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	List<Pessoa> findByNomeIgnoreCase(@Param("nome") String nome);
	
	Pessoa findById(@Param("id") long id);
	
	
}
