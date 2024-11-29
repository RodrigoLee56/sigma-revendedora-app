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

import com.rede.sigma.domain.Pedido.Pedido;
import com.rede.sigma.service.ClienteService;
import com.rede.sigma.service.MontadoraService;
import com.rede.sigma.service.PedidoService;
import com.rede.sigma.service.VendedorService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private VendedorService vendedorService;

	@Autowired
	private MontadoraService montadoraService;

	@GetMapping
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoService.listarTodos();
		model.addAttribute("pedidos", pedidos);
		return "pedidos/listar-pedidos";
	}

	@GetMapping("/novo")
	public String novoPedido(Model model) {
		model.addAttribute("pedido", new Pedido());
		model.addAttribute("clientes", clienteService.listarTodos());
		model.addAttribute("vendedores", vendedorService.listarTodos());
		model.addAttribute("montadoras", montadoraService.listarTodas());
		return "pedidos/form-pedido";
	}

	@PostMapping("/salvar")
	public String salvarPedido(@ModelAttribute Pedido pedido) {
		pedidoService.salvar(pedido);
		return "redirect:/pedidos";
	}
	
	@GetMapping("/editar/{numero}")
    public String editarPedido(@PathVariable Long numero, Model model) {
        Pedido pedido = pedidoService.buscarPorNumero(numero);
        model.addAttribute("pedido", pedido);
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("vendedores", vendedorService.listarTodos());
        model.addAttribute("montadoras", montadoraService.listarTodas());
        return "pedidos/form-pedido";
    }
}
