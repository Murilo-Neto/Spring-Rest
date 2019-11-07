package com.murilo.teste.controlle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murilo.teste.exception.RequestException;
import com.murilo.teste.model.Cidade;
import com.murilo.teste.repository.CidadeRepository;

@RestController
public class cidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
@PostMapping("cidades/cadastrar")	
public Cidade cadastrarCidade(@RequestParam String nome, @RequestParam String estado) {
	
		List<Cidade> cidadeLista = cidadeRepository.findByNomeIgnoreCase(nome);
		
		if(cidadeLista.isEmpty()) {
			
			Cidade cidade = new Cidade();
			cidade.setNome(nome);
			cidade.setEstado(estado);
			
			return cidadeRepository.save(cidade);
			
		}else {
			throw new RequestException("Cidade já Cadastrada");
		}
	
	}
	
	@GetMapping("/cidades/buscar/nome")
	public List<Cidade> buscarCidadeNome(@RequestParam String nome) {
		
		List<Cidade> cidade = cidadeRepository.findByNomeIgnoreCase(nome);
		
		if(!cidade.isEmpty()) {
			
			return cidade;
			
		}else {
			throw new RequestException("Cidade não Cadastrada");
		}
		
		
		
	}
	
	@GetMapping("/cidades/buscar/estado")
	public List<Cidade> buscarCidadeEstado(@RequestParam String estado){
		
		List<Cidade> cidade = cidadeRepository.findByEstadoIgnoreCase(estado);
		
		if(!cidade.isEmpty()) {
			
			return cidade;
			
		}else {
			throw new RequestException("Cidade não Cadastrada");
		}
		
		
	}

}
