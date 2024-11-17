package com.rede.sigma.domain.Pedido;

import java.util.Date;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Montadora.Montadora;
import com.rede.sigma.domain.Vendedor.Vendedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Date data;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Vendedor vendedor;

	@ManyToOne
	private Montadora montadora;

	private String modelo;
	private Integer ano;
	private String cor;
	private String acessorios;
	private Double valor;
}
