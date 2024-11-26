package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Pedido.Pedido;

@Service
public interface PedidoService {
	Pedido salvar(Pedido pedido);

	Pedido atualizar(Long numero, Pedido pedido);

	void deletar(Long numero);

	Pedido buscarPorNumero(Long numero);

	List<Pedido> listarTodos();

	Page<Pedido> listarPaginado(Pageable pageable);
}
