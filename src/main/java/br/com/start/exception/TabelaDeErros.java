package br.com.start.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

//erro de validacao -> BAD_REQUEST
//nao encontrado -> NOT_FOUND
//erro de negocio ->  PRECONDITION_FAILED
//
@Getter
@AllArgsConstructor
public enum TabelaDeErros {
	CLIENTE_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "Cliente não encontrado"),
	CLIENTE_DUPLICADO(HttpStatus.PRECONDITION_FAILED, "Cliente duplicado"),
	CLIENTE_VALIDACAO(HttpStatus.NOT_FOUND, "Cliente não encontrado");
	
	private final HttpStatus httpStatus;
	private final String erro;
}
