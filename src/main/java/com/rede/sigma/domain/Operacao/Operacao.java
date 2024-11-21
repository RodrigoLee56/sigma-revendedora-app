package com.rede.sigma.domain.Operacao;

import java.math.BigDecimal;
import java.util.Date;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.domain.Vendedor.Vendedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private Date data;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Vendedor vendedor;

	@ManyToOne
	@JoinColumn(name = "veiculo_numero_chassi")
	private Veiculo veiculo;

	@Column(name = "valor_entrada")
	private BigDecimal valorEntrada;

	@Column(name = "valor_financiado")
	private BigDecimal valorFinanciado;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;
}
