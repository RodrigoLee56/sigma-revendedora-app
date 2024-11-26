package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{cpf}")
	public Cliente atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
		return clienteService.atualizar(cpf, cliente);
	}

	@GetMapping("/{cpf}")
	public Cliente buscarClientePorCpf(@PathVariable String cpf) {
		return clienteService.buscarPorCpf(cpf);
	}

	@GetMapping
	public List<Cliente> listarTodosClientes() {
		return clienteService.listarTodos();
	}

}
