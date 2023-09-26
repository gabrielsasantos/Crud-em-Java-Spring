package br.com.start.model.dto;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.start.model.TipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteEntradaDto {

	@NotNull
	@Size(max =200, message= "tamanho inválido")
	private String nome;
	
	@Size(max =500, message= "tamanho inválido")
	private String requisito;
	
	@NotNull
	private TipoPessoa tipoCliente;
	
	@NotNull
	@Digits(integer=15, fraction=2)
	private Double valorContrato;
}
