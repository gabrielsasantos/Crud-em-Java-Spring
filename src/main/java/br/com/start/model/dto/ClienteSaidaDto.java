package br.com.start.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.start.model.TipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteSaidaDto {
	
	private Integer id;
	private String nome;
	private String requisito;
	private TipoPessoa tipoCliente;
	private Double valorContrato;

}
