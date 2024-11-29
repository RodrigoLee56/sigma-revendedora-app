package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rede.sigma.domain.Montadora.Montadora;
import com.rede.sigma.service.MontadoraService;

@Controller
@RequestMapping("/montadoras")
public class MontadoraController {
	@Autowired
	private MontadoraService montadoraService;

	@GetMapping
	public String listarMontadoras(Model model) {
		List<Montadora> montadoras = montadoraService.listarTodas();
		model.addAttribute("montadoras", montadoras);
		return "montadoras/listar-montadoras";
	}
}
