package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public String listarVeiculos(Model model) {
		List<Veiculo> veiculos = veiculoService.listarTodos();
		model.addAttribute("veiculos", veiculos);
		return "veiculos/listar-veiculos";
	}
}
