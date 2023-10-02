package br.com.start.model.dto;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
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

	@NotBlank (message = "obrigatorio")
	@Size(max =200, message= "máximo 200 caracteres")
	private String nome;
	
	@Size(max =500, message= "máximo 500 caracteres")
	private String requisito;
	
	@NotNull (message = "obrigatorio")
	private TipoPessoa tipoCliente;
	
	@NotNull (message = "obrigatorio")
	@Digits(integer=15, fraction=2 , message = "invalido, formato = 9.99")
	private Double valorContrato;
}
