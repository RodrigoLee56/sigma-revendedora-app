package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rede.sigma.domain.Montadora.Montadora;

public interface MontadoraService {
	Montadora salvar(Montadora montadora);

	Montadora atualizar(String cnpj, Montadora montadora);

	void deletar(String cnpj);

	Montadora buscarPorCnpj(String cnpj);

	List<Montadora> listarTodas();

	Page<Montadora> listarPaginado(Pageable pageable);
}
