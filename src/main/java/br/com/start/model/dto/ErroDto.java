package br.com.start.model.dto;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErroDto {

	private String erro;
	private List<String> validacoes;
	
}
