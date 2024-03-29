package br.com.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200, nullable=false, unique = true)
	private String nome;
	
	private String requisito;
	
	@Column(name="tipo_cliente")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoCliente;
	
	@Column(name="valor_contrato")
	private Double valorContrato;
}