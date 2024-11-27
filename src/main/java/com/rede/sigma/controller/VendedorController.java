package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rede.sigma.domain.Vendedor.Vendedor;
import com.rede.sigma.service.VendedorService;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@GetMapping
	public String listarVendedores(Model model) {
		List<Vendedor> vendedores = vendedorService.listarTodos();
		model.addAttribute("vendedores", vendedores);
		return "vendedores/listar-vendedores";
	}

	@GetMapping("/novo")
	public String novoVendedor(Model model) {
		model.addAttribute("vendedor", new Vendedor());
		return "vendedores/form-vendedor";
	}

	@PostMapping("/salvar")
	public String salvarVendedor(@ModelAttribute Vendedor vendedor) {
		vendedorService.salvar(vendedor);
		return "redirect:/vendedores";
	}

	@PostMapping("/atualizar")
	public String atualizarVendedor(@ModelAttribute Vendedor vendedor) {
		vendedorService.atualizar(vendedor.getCodigo(), vendedor);
		return "redirect:/vendedores";
	}

	@GetMapping("/deletar/{codigo}")
	public String deletarVendedor(@PathVariable Integer codigo) {
		vendedorService.deletar(codigo);
		return "redirect:/vendedores";
	}

}
