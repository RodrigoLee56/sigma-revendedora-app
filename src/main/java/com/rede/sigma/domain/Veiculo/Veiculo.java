package com.rede.sigma.domain.Veiculo;

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
	private Double valor;
}
