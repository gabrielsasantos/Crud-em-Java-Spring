package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.ErroDeNegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Cliente;
import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.model.dto.ClienteSaidaDto;
import br.com.start.repository.ClienteRepository;
import br.com.start.validator.ClienteValidator;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteValidator validator;

	@Autowired
	private ModelMapper mapper;

	public ClienteSaidaDto criar(ClienteEntradaDto entradaDto) {
		validator.criar(entradaDto);

		Cliente cliente = mapper.map(entradaDto, Cliente.class);
		Cliente clienteBanco = repository.save(cliente);
		ClienteSaidaDto saidaDto = mapper.map(clienteBanco, ClienteSaidaDto.class);

		return saidaDto;
	}

	public void alterar(Integer id, ClienteEntradaDto entradaDto) {
		validator.alterar(id, entradaDto);
		Optional<Cliente> optional = repository.findById(id);

		if (optional.isPresent()) {
			Cliente clienteBanco = optional.get();

			mapper.map(entradaDto, clienteBanco);

			repository.save(clienteBanco);
		} else {
			throw new ErroDeNegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);
		}
	}

	public ClienteSaidaDto pegarUm(Integer id) {
		Optional<Cliente> optional = repository.findById(id);

		if (optional.isPresent()) {
			Cliente clienteBanco = optional.get();

			ClienteSaidaDto saidaDto = mapper.map(clienteBanco, ClienteSaidaDto.class);

			return saidaDto;

		}
		throw new ErroDeNegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);
	}

	public void excluir(Integer id) {

		validator.excluir(id);
		repository.deleteById(id);

	}

	public List<ClienteSaidaDto> listar() {
		List<Cliente> clientes = repository.findAll();

		List<ClienteSaidaDto> saidaDto = mapper.map(clientes, new TypeToken<List<ClienteSaidaDto>>() {
		}.getType());
		return saidaDto;
	}

}
