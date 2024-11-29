package com.rede.sigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rede.sigma.domain.Operacao.Operacao;
import com.rede.sigma.service.ClienteService;
import com.rede.sigma.service.MontadoraService;
import com.rede.sigma.service.OperacaoService;
import com.rede.sigma.service.PedidoService;
import com.rede.sigma.service.VendedorService;

@Controller
@RequestMapping("/operacoes")
public class OperacaoController {
	@Autowired
	private OperacaoService operacaoService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private VendedorService vendedorService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private MontadoraService montadoraService;

	@GetMapping
	public String listarOperacoes(Model model) {
		List<Operacao> operacoes = operacaoService.listarTodas();
		model.addAttribute("operacoes", operacoes);
		return "operacoes/listar-operacoes";
	}
}
