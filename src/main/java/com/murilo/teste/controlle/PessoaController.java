package com.murilo.teste.controlle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murilo.teste.exception.RequestException;
import com.murilo.teste.model.Pessoa;
import com.murilo.teste.repository.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping("/pessoas/cadastrar")
	public Pessoa cadastrarPessoa(@RequestParam String nome, @RequestParam String sexo, @RequestParam String cidade, @RequestParam int idade, @RequestParam String data) {
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setSexo(sexo);
		pessoa.setCidade(cidade);
		pessoa.setIdade(idade);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateTime = LocalDate.parse(data, formatter);
		pessoa.setData(dateTime);
		
		return pessoaRepository.save(pessoa);
		
		 
	}
	
	@GetMapping("/pessoas/buscar")
	public List<Pessoa> buscaPessoaNome(@RequestParam String nome){
		
		List <Pessoa> pessoa = pessoaRepository.findByNomeIgnoreCase(nome);
		
		if (!pessoa.isEmpty()) {
			
			return pessoa;
			
		}else {
			throw new RequestException("Pessoa Não Cadastrada");
		}
		
		
		
	}
	
	
	@GetMapping("/pessoas/buscar2")
	public Pessoa buscaPessoaId(@RequestParam long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id);
		
		if (pessoa != null) {
			
			return pessoa;
		}
		else {
			throw new RequestException("Pessoa Não Cadastrada");
		}

	}
	
	// pessoas/deletar?id=2
	// pessoas/deletar/2
	
	@DeleteMapping("/pessoas/deletar/{id}")
	  public void delete(@PathVariable("id") long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id);
		
		if (pessoa != null) {
			pessoaRepository.delete(pessoa);
		} else {
			throw new RequestException("Deu erro");
		}
		
	  }

}
