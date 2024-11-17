package com.rede.sigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rede.sigma.domain.Cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
