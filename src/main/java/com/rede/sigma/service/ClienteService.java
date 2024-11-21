package com.rede.sigma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Cliente.Cliente;

@Service
public interface ClienteService {

	Cliente salvar(Cliente cliente);

	Cliente atualizar(String cpf, Cliente cliente);

	void deletar(String cpf);

	Cliente buscarPorCpf(String cpf);

	List<Cliente> listarTodos();

	Page<Cliente> listarPaginado(Pageable pageable);

	List<Cliente> listarOrdenadosPorNome();

}
