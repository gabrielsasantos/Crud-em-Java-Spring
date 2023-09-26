package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import br.com.start.model.Cliente;
import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.model.dto.ClienteSaidaDto;
import br.com.start.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	public ClienteSaidaDto salvar(ClienteEntradaDto entradaDto) {

		Cliente cliente= mapper.map(entradaDto, Cliente.class);

		Cliente clienteBanco = repository.save(cliente);

		ClienteSaidaDto saidaDto = mapper.map(clienteBanco, ClienteSaidaDto.class);

		return saidaDto;
	}

	public boolean alterar(Integer id, ClienteEntradaDto entradaDto) {
		Optional<Cliente> optinal = repository.findById(id);

		if (optinal.isPresent()) {

			Cliente clienteBanco = optinal.get();
			
			mapper.map(entradaDto, clienteBanco);

			repository.save(clienteBanco);
			
			return true;

		}
		
		return false;
	}

	public ClienteSaidaDto pegarUm(Integer id) {
		Optional<Cliente> optional = repository.findById(id);

		if (optional.isPresent()) {
			Cliente clienteBanco = optional.get();
			
			ClienteSaidaDto saidaDto = mapper.map(clienteBanco, ClienteSaidaDto.class);

			return saidaDto;

		}
		return null;
	}

	public boolean excluir(Integer id) {

		if (!repository.existsById(id)) {
			return false;
		}

		repository.deleteById(id);

		return true;
	}

	public List<ClienteSaidaDto> listar() {
		List<Cliente> clientes= repository.findAll();
		
		List<ClienteSaidaDto> saidaDto = mapper.map(clientes, new TypeToken<List<ClienteSaidaDto>>() {}.getType());
		return saidaDto;
	}

}
