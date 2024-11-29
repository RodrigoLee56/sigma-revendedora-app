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

	@GetMapping("/novo")
	public String novaOperacao(Model model) {
		model.addAttribute("operacao", new Operacao());
		model.addAttribute("pedidos", pedidoService.listarTodos());
		model.addAttribute("clientes", clienteService.listarTodos());
		model.addAttribute("vendedores", vendedorService.listarTodos());
		model.addAttribute("montadoras", montadoraService.listarTodas());
		return "operacoes/form-operacao";
	}

	@PostMapping("/salvar")
	public String salvarOperacao(@ModelAttribute Operacao operacao) {
		operacaoService.salvar(operacao);
		return "redirect:/operacoes";
	}

	@GetMapping("/editar/{numero}")
	public String editarOperacao(@PathVariable Long numero, Model model) {
		Operacao operacao = operacaoService.buscarPorNumero(numero);
		model.addAttribute("operacao", operacao);
		model.addAttribute("pedidos", pedidoService.listarTodos());
		model.addAttribute("clientes", clienteService.listarTodos());
		model.addAttribute("vendedores", vendedorService.listarTodos());
		model.addAttribute("montadoras", montadoraService.listarTodas());
		return "operacoes/form-operacao";
	}

	@PostMapping("/atualizar")
	public String atualizarOperacao(@ModelAttribute Operacao operacao) {
		operacaoService.atualizar(operacao.getNumero(), operacao);
		return "redirect:/operacoes";
	}

	@GetMapping("/deletar/{numero}")
	public String deletarOperacao(@PathVariable Long numero) {
		operacaoService.deletar(numero);
		return "redirect:/operacoes";
	}

}
