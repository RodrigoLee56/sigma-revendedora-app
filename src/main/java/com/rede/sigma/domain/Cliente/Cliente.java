package com.rede.sigma.domain.Cliente;

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
	private String name;
	private String endereco;
	private String telefone;
	private Double renda;
}
