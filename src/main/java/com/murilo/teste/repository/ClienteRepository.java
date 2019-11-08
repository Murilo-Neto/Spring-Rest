package com.murilo.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.murilo.teste.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNomeIgnoreCase(@Param("nome") String nome);
	
	Cliente findById(@Param("id") long id);
	
	
}
