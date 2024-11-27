package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
