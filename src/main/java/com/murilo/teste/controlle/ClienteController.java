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
import com.murilo.teste.model.Cliente;
import com.murilo.teste.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/clientes/cadastrar")
	public Cliente cadastrarPessoa(@RequestParam String nome, @RequestParam String sexo, @RequestParam String cidade, @RequestParam int idade, @RequestParam String data) {
		
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setSexo(sexo);
		cliente.setCidade(cidade);
		cliente.setIdade(idade);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateTime = LocalDate.parse(data, formatter);
		cliente.setData(dateTime);
		
		return clienteRepository.save(cliente);
		
		 
	}
	
	@GetMapping("/clientes/buscar/nome")
	public List<Cliente> buscaPessoaNome(@RequestParam String nome){
		
		List <Cliente> cliente = clienteRepository.findByNomeIgnoreCase(nome);
		
		if (!cliente.isEmpty()) {
			
			return cliente;
			
		}else {
			throw new RequestException("Não Existe NenhumCliente Cadastrado Com Este Nome");
		}
		
		
		
	}
	
	
	@GetMapping("/clientes/buscar/identificador")
	public Cliente buscaPessoaId(@RequestParam long id) {
		
		Cliente cliente = clienteRepository.findById(id);
		
		if (cliente != null) {
			
			return cliente;
		}
		else {
			throw new RequestException("Não Existe Nenhum cliente Cadastrado Com Este Id");
		}

	}
	
	@DeleteMapping("/clientes/deletar/{id}")
	  public void delete(@PathVariable("id") long id) {
		
		Cliente cliente = clienteRepository.findById(id);
		
		if (cliente != null) {
			clienteRepository.delete(cliente);
		} else {
			throw new RequestException("O Cliente Não foi Cadastrado, Por isso Não é Possível Remover");
		}
		
	  }
	
	@PostMapping("/clientes/alterar")
	public Cliente alteraNome(@RequestParam String nome, @RequestParam long id) {
		
		Cliente cliente = clienteRepository.findById(id);
		
		if(cliente != null) {
			
			cliente.setNome(nome);
			
			return clienteRepository.save(cliente);
			
		}else{
			throw new RequestException("O Cliente Não foi Cadastrado, Por isso Não é Possível Alterar");
		}
		
	}

}
