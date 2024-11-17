package com.rede.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Operacao.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
