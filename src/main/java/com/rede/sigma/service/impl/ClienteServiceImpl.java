package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Cliente.Cliente;
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
	public Cliente salvar(Cliente cliente){
		if (!CpfValidator.isValid(cliente.getCpf())) {
			throw new InvalidCpfException("CPF Inválido!");
		}
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarOrdenadosPorNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
