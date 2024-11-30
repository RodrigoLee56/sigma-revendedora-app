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
import org.springframework.web.bind.annotation.RequestParam;

import com.rede.sigma.domain.Vendedor.Vendedor;
import com.rede.sigma.exeption.InvalidUsernameOrPasswordException;
import com.rede.sigma.service.VendedorService;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}

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

	@PostMapping("/novo")
	public String salvarVendedor(@ModelAttribute Vendedor vendedor, Model model) {
		vendedorService.salvar(vendedor);
		model.addAttribute("vendedor", vendedor);
		return "vendedores/vendedor-index";
	}

	@GetMapping("/editar/{codigo}")
	public String editarVendedor(@PathVariable Integer codigo, Model model) {
		Vendedor vendedor = vendedorService.buscarPorCodigo(codigo);
		model.addAttribute("vendedor", vendedor);
		return "vendedores/form-vendedor";
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

	@PostMapping("/login")
	public String autenticar(@RequestParam String usuario, @RequestParam String senha, Model model) {
		try {
			Vendedor vendedor = vendedorService.login(usuario, senha);
			model.addAttribute("vendedor", vendedor);
			return "vendedores/vendedor-index";
		} catch (InvalidUsernameOrPasswordException e) {
			model.addAttribute("erro", e);
			return "index";
		}
	}

}
