package br.com.start.model.dto;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.start.model.EnumTipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ClienteEntradaDto {

	@NotNull
	@Size(max =200, message= "tamanho inválido")
	@Id
	private String nome;
	
	@Size(max =500, message= "tamanho inválido")
	private String requisito;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoCliente;
	
	@NotNull
	@Digits (integer=15, fraction=2)
	private Double valorContrato;
}
