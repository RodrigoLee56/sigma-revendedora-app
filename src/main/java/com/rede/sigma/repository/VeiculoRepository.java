package com.rede.sigma.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
	// Buscar veículos por marca
	List<Veiculo> findByMarca(String marca);

	// Buscar veículos por modelo
	List<Veiculo> findByModelo(String modelo);

	// Buscar veículos por marca e modelo
	List<Veiculo> findByMarcaAndModelo(String marca, String modelo);

	// Buscar veículos paginados por marca
	Page<Veiculo> findByMarca(String marca, Pageable pageable);

	// Buscar veículos paginados por ano de fabricação
	Page<Veiculo> findByAnoFabricacao(Integer anoFabricacao, Pageable pageable);

	// Buscar veículos paginados por cor
	Page<Veiculo> findByCor(String cor, Pageable pageable);
}
