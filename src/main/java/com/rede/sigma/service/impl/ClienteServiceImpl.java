package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.exeption.ClienteNotFoundException;
import com.rede.sigma.exeption.InvalidCpfException;
import com.rede.sigma.repository.ClienteRepository;
import com.rede.sigma.service.ClienteService;
import com.rede.sigma.util.CpfValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	@Override
	public Cliente salvar(Cliente cliente) {
		if (!CpfValidator.isValid(cliente.getCpf())) {
			throw new InvalidCpfException("CPF Inválido!");
		}
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(String cpf, Cliente cliente) {
		if (!CpfValidator.isValid(cliente.getCpf())) {
			throw new InvalidCpfException("CPF inválido!");
		}
		Cliente clienteExistente = clienteRepository.findById(cpf)
				.orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com CPF: " + cpf));
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setEndereco(cliente.getEndereco());
		clienteExistente.setTelefone(cliente.getTelefone());
		clienteExistente.setRenda(cliente.getRenda());

		return clienteRepository.save(clienteExistente);
	}

	@Override
	public void deletar(String cpf) {
		clienteRepository.deleteById(cpf);
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return clienteRepository.findById(cpf)
				.orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com CPF: " + cpf));
	}

	@Override
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public List<Cliente> listarOrdenadosPorNome() {
		return clienteRepository.findAllOrderedByName();
	}

	@Override
	public Page<Cliente> listarPaginado(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

}
