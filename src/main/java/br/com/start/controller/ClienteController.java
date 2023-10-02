package br.com.start.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.model.dto.ClienteSaidaDto;
import br.com.start.service.ClienteService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("clientes")
@Log4j2
public class ClienteController {

	@Autowired
	private ClienteService service;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ClienteSaidaDto salvar(@Valid @RequestBody ClienteEntradaDto entradaDto) {
		log.info("salvar: entradaDto={}", entradaDto);

		return service.salvar(entradaDto);
	}

	@PutMapping("id/{id}")
	public void alterar(@PathVariable("id") Integer id, @Valid @RequestBody ClienteEntradaDto entradaDto) {
		log.info("alterar: id={}, entradaDto={}", id, entradaDto);
		service.alterar(id, entradaDto);

	}

	@GetMapping("id/{id}")
	public ClienteSaidaDto pagarUm(@PathVariable("id") Integer id) {
		log.info("pegarUm: id={}", id);

		return service.pegarUm(id);
	}

	@DeleteMapping("id/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		log.info("excluir: id={}", id);

		service.excluir(id);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("listar")
	public List<ClienteSaidaDto> listar() {
		log.info("listar");

		return service.listar();
	}
}