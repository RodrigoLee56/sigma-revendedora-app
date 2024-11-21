package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rede.sigma.domain.Veiculo.Veiculo;

public interface VeiculoService {
	Veiculo salvar(Veiculo veiculo);

	Veiculo atualizar(String numeroChassi, Veiculo veiculo);

	void deletar(String numeroChassi);

	Veiculo buscarPorNumeroChassi(String numeroChassi);

	List<Veiculo> listarTodos();

	Page<Veiculo> listarPaginado(Pageable pageable);

	List<Veiculo> listarPorMarca(String marca);

	Page<Veiculo> listarPorMarcaPaginado(String marca, Pageable pageable);

	Page<Veiculo> listarPorAnoFabricacaoPaginado(Integer anoFabricacao, Pageable pageable);

	Page<Veiculo> listarPorCorPaginado(String cor, Pageable pageable);
}
