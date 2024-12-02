package com.rede.sigma.controller;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Operacao.Operacao;
import com.rede.sigma.domain.Operacao.TipoOperacao;
import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.domain.Vendedor.Vendedor;
import com.rede.sigma.service.ClienteService;
import com.rede.sigma.service.OperacaoService;
import com.rede.sigma.service.VeiculoService;
import com.rede.sigma.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    private OperacaoService operacaoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public String listarOperacoes(Model model) {
        List<Operacao> operacoes = operacaoService.listarTodas();
        model.addAttribute("operacoes", operacoes);
        return "operacoes/listar-operacoes";
    }

    @GetMapping("/novo")
    public String novaOperacao(Model model) {
        model.addAttribute("operacao", new Operacao());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("vendedores", vendedorService.listarTodos());
        model.addAttribute("veiculos", veiculoService.listarTodos());
        model.addAttribute("tiposOperacao", TipoOperacao.values());
        return "operacoes/form-operacao";
    }

    @PostMapping("/salvar")
    public String salvarOperacao(@ModelAttribute Operacao operacao) {
        Cliente cliente = clienteService.buscarPorCpf(operacao.getCliente().getCpf());
        Vendedor vendedor = vendedorService.buscarPorCodigo(operacao.getVendedor().getCodigo());
        Veiculo veiculo = veiculoService.buscarPorNumeroChassi(operacao.getVeiculo().getNumeroChassi());
        operacao.setCliente(cliente);
        operacao.setVendedor(vendedor);
        operacao.setVeiculo(veiculo);

        operacaoService.salvar(operacao);
        return "redirect:/operacoes";
    }

    @GetMapping("/editar/{numero}")
    public String editarOperacao(@PathVariable Long numero, Model model) {
        Operacao operacao = operacaoService.buscarPorNumero(numero);
        model.addAttribute("operacao", operacao);
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("vendedores", vendedorService.listarTodos());
        model.addAttribute("veiculos", veiculoService.listarTodos());
        model.addAttribute("tiposOperacao", TipoOperacao.values());
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

    @GetMapping("/{numero}")
    public String verOperacao(@PathVariable Long numero, Model model) {
        Operacao operacao = operacaoService.buscarPorNumero(numero);
        model.addAttribute("operacao", operacao);
        return "operacoes/ver-operacao";
    }
}
