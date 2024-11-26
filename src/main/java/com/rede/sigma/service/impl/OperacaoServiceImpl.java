package com.rede.sigma.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Operacao.Operacao;
import com.rede.sigma.exeption.OperacaoNotFoundException;
import com.rede.sigma.repository.OperacaoRepository;
import com.rede.sigma.service.OperacaoService;

@Service
public class OperacaoServiceImpl implements OperacaoService {

	@Autowired
	private OperacaoRepository operacaoRepository;

	@Override
	public Operacao salvar(Operacao operacao) {
		return operacaoRepository.save(operacao);
	}

	@Override
	public Operacao atualizar(Long numero, Operacao operacao) {
		Operacao operacaoExistente = operacaoRepository.findById(numero)
				.orElseThrow(() -> new OperacaoNotFoundException("Operação não encontrada com número: " + numero));
		operacaoExistente.setCliente(operacao.getCliente());
		operacaoExistente.setVendedor(operacao.getVendedor());
		operacaoExistente.setVeiculo(operacao.getVeiculo());
		operacaoExistente.setData(operacao.getData());
		operacaoExistente.setValorEntrada(operacao.getValorEntrada());
		operacaoExistente.setValorFinanciado(operacao.getValorFinanciado());
		operacaoExistente.setValorTotal(operacao.getValorTotal());
		return operacaoRepository.save(operacaoExistente);
	}

	@Override
	public void deletar(Long numero) {
		operacaoRepository.deleteById(numero);
	}

	@Override
	public Operacao buscarPorNumero(Long numero) {
		return operacaoRepository.findById(numero)
				.orElseThrow(() -> new OperacaoNotFoundException("Operação não encontrada com número: " + numero));
	}

	@Override
	public List<Operacao> listarTodas() {
		return operacaoRepository.findAll();
	}

	@Override
	public Page<Operacao> listarPaginado(Pageable pageable) {
		return operacaoRepository.findAll(pageable);
	}

	@Override
	public List<Operacao> listarPorCliente(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operacao> listarPorVendedor(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operacao> listarPorIntervaloDeDatas(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operacao> listarPorValorMaiorQue(Double valor) {
		// TODO Auto-generated method stub
		return null;
	}
}
