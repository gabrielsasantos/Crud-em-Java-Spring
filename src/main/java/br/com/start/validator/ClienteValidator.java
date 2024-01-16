package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.ErroDeNegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.dto.ClienteEntradaDto;
import br.com.start.repository.ClienteRepository;

@Component
public class ClienteValidator {

	@Autowired
	private ClienteRepository repository;

	public void criar(ClienteEntradaDto entradaDto) {
		String nome = entradaDto.getNome();
		if (repository.existsByNome(nome)) {
			throw new ErroDeNegocioException(TabelaDeErros.CLIENTE_DUPLICADO);
		}

	}

	public void alterar(Integer id, ClienteEntradaDto entradaDto) {
		String novoNome = entradaDto.getNome();
		if (repository.existsByNomeAndIdNot(novoNome, id)) {
			throw new ErroDeNegocioException(TabelaDeErros.CLIENTE_DUPLICADO);
		}
	}

	public void excluir(Integer id) {

		if (!repository.existsById(id)) {
			throw new ErroDeNegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);
		}

	}

}
