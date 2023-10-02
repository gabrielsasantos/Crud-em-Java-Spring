package br.com.start.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ErroDeNegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final  HttpStatus httpStatus;
	private final String erro;
	
	

}
