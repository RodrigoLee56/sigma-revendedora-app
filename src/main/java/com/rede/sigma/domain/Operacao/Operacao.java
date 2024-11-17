package com.rede.sigma.domain.Operacao;

import java.util.Date;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.domain.Vendedor.Vendedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operacoes")
public class Operacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Vendedor vendedor;

	@ManyToOne
	private Veiculo veiculo;

	private Double valorEntrada;
	private Double valorFinanciado;
	private Double valorTotal;
}
