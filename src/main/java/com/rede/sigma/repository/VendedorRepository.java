package com.rede.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Vendedor.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	
	Vendedor findByUsuarioAndSenha(String usuario, String senha);
}
