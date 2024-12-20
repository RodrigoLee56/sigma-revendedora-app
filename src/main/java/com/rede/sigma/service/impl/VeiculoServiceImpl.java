package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.exeption.VeiculoNotFoundException;
import com.rede.sigma.repository.VeiculoRepository;
import com.rede.sigma.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public Veiculo atualizar(String numeroChassi, Veiculo veiculo) {
		Veiculo veiculoExistente = veiculoRepository.findById(numeroChassi).orElseThrow(
				() -> new VeiculoNotFoundException("Veículo não encontrado com número de chassi: " + numeroChassi));
		veiculoExistente.setMarca(veiculo.getMarca());
		veiculoExistente.setModelo(veiculo.getModelo());
		veiculoExistente.setAnoFabricacao(veiculo.getAnoFabricacao());
		veiculoExistente.setAnoModelo(veiculo.getAnoModelo());
		veiculoExistente.setCor(veiculo.getCor());
		veiculoExistente.setValor(veiculo.getValor());
		return veiculoRepository.save(veiculoExistente);
	}

	@Override
	public void deletar(String numeroChassi) {
		veiculoRepository.deleteById(numeroChassi);
	}

	@Override
	public Veiculo buscarPorNumeroChassi(String numeroChassi) {
		return veiculoRepository.findById(numeroChassi).orElseThrow(
				() -> new VeiculoNotFoundException("Veículo não encontrado com número de chassi: " + numeroChassi));
	}

	@Override
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	@Override
	public Page<Veiculo> listarPaginado(Pageable pageable) {
		return veiculoRepository.findAll(pageable);
	}

	@Override
	public List<Veiculo> listarPorMarca(String marca) {
		return veiculoRepository.findByMarca(marca);
	}

	@Override
	public Page<Veiculo> listarPorMarcaPaginado(String marca, Pageable pageable) {
		return veiculoRepository.findByMarca(marca, pageable);
	}

	@Override
	public Page<Veiculo> listarPorAnoFabricacaoPaginado(Integer anoFabricacao, Pageable pageable) {
		return veiculoRepository.findByAnoFabricacao(anoFabricacao, pageable);
	}

	@Override
	public Page<Veiculo> listarPorCorPaginado(String cor, Pageable pageable) {
		return veiculoRepository.findByCor(cor, pageable);
	}
}
