package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Operacao.Operacao;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Operacao buscarPorNumero(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operacao> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Operacao> listarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
