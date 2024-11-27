package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

	@PutMapping("/{cpf}")
	public Cliente atualizarCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
		return clienteService.atualizar(cpf, cliente);
	}

	@DeleteMapping("/{cpf}")
	public Cliente deletarClientePorCpf(@PathVariable String cpf) {
		Cliente cliente = clienteService.buscarPorCpf(cpf);
		clienteService.deletar(cpf);
		return cliente;
	}

	@GetMapping("/{cpf}")
	public Cliente buscarClientePorCpf(@PathVariable String cpf) {
		return clienteService.buscarPorCpf(cpf);
	}

	@GetMapping
	public List<Cliente> listarTodosClientes() {
		return clienteService.listarTodos();
	}

	@GetMapping("/paginado")
	public Page<Cliente> listarClientesPaginados(Pageable pageable) {
		return clienteService.listarPaginado(pageable);
	}

	@GetMapping("/ordenados")
	public List<Cliente> listarClientesOrdenados() {
		return clienteService.listarOrdenadosPorNome();
	}

}
