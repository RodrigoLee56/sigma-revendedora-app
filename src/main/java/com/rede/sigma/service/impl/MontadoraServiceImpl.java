package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Montadora.Montadora;
import com.rede.sigma.repository.MontadoraRepository;
import com.rede.sigma.service.MontadoraService;

@Service
public class MontadoraServiceImpl implements MontadoraService {

	@Autowired
	private MontadoraRepository montadoraRepository;

	@Override
	public Montadora salvar(Montadora montadora) {
		return montadoraRepository.save(montadora);
	}

	@Override
	public Montadora atualizar(String cnpj, Montadora montadora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(String cnpj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Montadora buscarPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Montadora> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Montadora> listarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
