package com.rede.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
