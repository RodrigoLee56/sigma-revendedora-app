package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rede.sigma.domain.Vendedor.Vendedor;

public interface VendedorService {
	Vendedor salvar(Vendedor vendedor);

	Vendedor atualizar(Integer codigo, Vendedor vendedor);

	void deletar(Integer codigo);

	Vendedor buscarPorCodigo(Integer codigo);

	List<Vendedor> listarTodos();

	Page<Vendedor> listarPaginado(Pageable pageable);
}
