package br.com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	  boolean existsByNome(String nome);
	  
	  boolean existsByNomeAndIdNot(String nome, Integer id);


}
