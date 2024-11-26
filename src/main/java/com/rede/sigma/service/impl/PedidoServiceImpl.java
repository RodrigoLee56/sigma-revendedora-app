package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Pedido.Pedido;
import com.rede.sigma.exeption.PedidoNotFoundException;
import com.rede.sigma.repository.PedidoRepository;
import com.rede.sigma.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido atualizar(Long numero, Pedido pedido) {
		Pedido pedidoExistente = pedidoRepository.findById(numero)
				.orElseThrow(() -> new PedidoNotFoundException("Pedido não encontrado com número: " + numero));
		pedidoExistente.setCliente(pedido.getCliente());
		pedidoExistente.setVendedor(pedido.getVendedor());
		pedidoExistente.setMontadora(pedido.getMontadora());
		pedidoExistente.setModelo(pedido.getModelo());
		pedidoExistente.setAno(pedido.getAno());
		pedidoExistente.setCor(pedido.getCor());
		pedidoExistente.setAcessorios(pedido.getAcessorios());
		pedidoExistente.setValor(pedido.getValor());
		return pedidoRepository.save(pedidoExistente);
	}

	@Override
	public void deletar(Long numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido buscarPorNumero(Long numero) {
		return pedidoRepository.findById(numero)
				.orElseThrow(() -> new PedidoNotFoundException("Pedido não encontrado com número: " + numero));
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
