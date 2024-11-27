package com.rede.sigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/novo")
	public String novoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "form-cliente";
	}

	@GetMapping("/editar/{cpf}")
	public String editarCliente(@PathVariable String cpf, Model model) {
		Cliente cliente = clienteService.buscarPorCpf(cpf);
		model.addAttribute("cliente", cliente);
		return "form-cliente";
	}

	@PostMapping("/atualizar")
	public String atualizarCliente(@ModelAttribute Cliente cliente) {
		clienteService.atualizar(cliente.getCpf(), cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/deletar/{cpf}")
	public String deletarCliente(@PathVariable String cpf) {
		clienteService.deletar(cpf);
		return "redirect:/clientes";
	}
}
