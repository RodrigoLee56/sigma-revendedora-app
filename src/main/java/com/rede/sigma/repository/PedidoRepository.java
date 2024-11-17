package com.rede.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
