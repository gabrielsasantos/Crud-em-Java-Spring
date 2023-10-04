package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.start.exception.ErroDeNegocioException;
import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.repository.ClienteRepository;

@Component
public class ClienteValidator {

	@Autowired
	private ClienteRepository repository;

	public void criar(ClienteEntradaDto entradaDto) {
		String nome = entradaDto.getNome();
		if (repository.existsByNome(nome)) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Nome duplicado");
		}

	}

	public void alterar(Integer id, ClienteEntradaDto entradaDto) {
		String novoNome = entradaDto.getNome();
		if (repository.existsByNomeAndIdNot(novoNome, id)) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Nome duplicado");
		}
	}

	public void excluir(Integer id) {

		if (!repository.existsById(id)) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Não encontrada");
		}

	}

}
