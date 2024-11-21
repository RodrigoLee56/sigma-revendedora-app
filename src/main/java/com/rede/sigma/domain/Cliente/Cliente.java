package com.rede.sigma.domain.Cliente;

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
@Table(name = "clientes")
public class Cliente {

	@Id
	private String cpf;
	
	private String nome;
	private String endereco;
	private String telefone;
	@Column(columnDefinition = "NUMERIC(10, 2)")
	private BigDecimal renda;

}
