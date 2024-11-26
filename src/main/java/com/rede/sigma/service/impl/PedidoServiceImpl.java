package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Pedido.Pedido;
import com.rede.sigma.repository.PedidoRepository;
import com.rede.sigma.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
    private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido salvar(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido atualizar(Integer numero, Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Integer numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido buscarPorNumero(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Pedido> listarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
