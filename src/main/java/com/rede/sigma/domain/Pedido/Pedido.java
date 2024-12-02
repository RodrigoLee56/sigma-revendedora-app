package com.rede.sigma.domain.Pedido;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Montadora.Montadora;
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
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "vendedor_codigo")
	private Vendedor vendedor;

	@ManyToOne
	private Montadora montadora;

	private String modelo;
	private Integer ano;
	private String cor;
	private String acessorios;

	@Column(columnDefinition = "NUMERIC(10, 2)")
	private BigDecimal valor;
}
