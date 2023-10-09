package br.com.start.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErroDeNegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final  HttpStatus httpStatus;
	private final String erro;
	
	public ErroDeNegocioException(TabelaDeErros tabelaDeErros) {
		super();
		this.httpStatus = tabelaDeErros.getHttpStatus();
		this.erro = tabelaDeErros.getErro();
	}
}
