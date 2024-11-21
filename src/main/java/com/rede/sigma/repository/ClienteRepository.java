package com.rede.sigma.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rede.sigma.domain.Cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	@Query("SELECT c FROM Cliente c ORDER BY c.nome ASC")
	List<Cliente> findAllOrderedByName();

	@Override
	Page<Cliente> findAll(Pageable pageable);
}
