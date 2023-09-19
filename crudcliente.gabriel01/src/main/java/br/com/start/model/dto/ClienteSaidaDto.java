package br.com.start.model.dto;

import br.com.start.model.EnumTipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteSaidaDto {
	
	private Integer id;
	private String nome;
	private String requisito;
	private EnumTipoPessoa tipoCliente;
	private Double valorContrato;

}
