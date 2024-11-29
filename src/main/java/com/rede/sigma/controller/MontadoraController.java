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
	
	@GetMapping("/novo")
    public String novaMontadora(Model model) {
        model.addAttribute("montadora", new Montadora());
        return "montadoras/form-montadora";
    }
	
	@PostMapping("/salvar")
    public String salvarMontadora(@ModelAttribute Montadora montadora) {
        montadoraService.salvar(montadora);
        return "redirect:/montadoras";
    }
	
	@GetMapping("/editar/{cnpj}")
    public String editarMontadora(@PathVariable String cnpj, Model model) {
        Montadora montadora = montadoraService.buscarPorCnpj(cnpj);
        model.addAttribute("montadora", montadora);
        return "montadoras/form-montadora";
    }
	
	@PostMapping("/atualizar")
    public String atualizarMontadora(@ModelAttribute Montadora montadora) {
        montadoraService.atualizar(montadora.getCnpj(), montadora);
        return "redirect:/montadoras";
    }
	
	@GetMapping("/deletar/{cnpj}")
    public String deletarMontadora(@PathVariable String cnpj) {
        montadoraService.deletar(cnpj);
        return "redirect:/montadoras";
    }
	
	
	
}
