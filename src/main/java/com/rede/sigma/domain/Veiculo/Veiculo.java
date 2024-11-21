package com.rede.sigma.domain.Veiculo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculos")
public class Veiculo {

	@Id
	private String numeroChassi;
	
	private String placa;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String cor;
	
	@Column(columnDefinition = "NUMERIC(10, 2)")
	private BigDecimal valor;
}
