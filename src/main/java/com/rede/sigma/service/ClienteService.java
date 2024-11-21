package com.rede.sigma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Cliente.Cliente;

@Service
public interface ClienteService {

	Cliente salvar(Cliente cliente);

	Cliente atualizar(Long id, Cliente cliente);

	void deletar(Long id);

	Cliente buscarPorId(Long id);

	List<Cliente> listarTodos();

	List<Cliente> listarOrdenadosPorNome();

}
