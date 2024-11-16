package com.rede.sigma.domain.Montadora;

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
@Table(name = "montadoras")
public class Montadora {
	@Id
	private String cnpj;

	private String razaoSocial;
	private String marca;
	private String contato;
	private String telefone;
}
