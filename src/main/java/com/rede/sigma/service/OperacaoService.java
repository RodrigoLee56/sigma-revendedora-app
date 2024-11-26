package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Operacao.Operacao;

@Service
public interface OperacaoService {
	Operacao salvar(Operacao operacao);

	Operacao atualizar(Long numero, Operacao operacao);

	void deletar(Long numero);

	Operacao buscarPorNumero(Long numero);

	List<Operacao> listarTodas();

	Page<Operacao> listarPaginado(Pageable pageable);
}
