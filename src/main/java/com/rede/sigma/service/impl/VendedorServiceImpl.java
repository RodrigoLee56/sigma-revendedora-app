package com.rede.sigma.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rede.sigma.domain.Vendedor.Vendedor;
import com.rede.sigma.exeption.VendedorNotFoundException;
import com.rede.sigma.repository.VendedorRepository;
import com.rede.sigma.service.VendedorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VendedorServiceImpl implements VendedorService {

	private VendedorRepository vendedorRepository;

	@Override
	public Vendedor salvar(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor atualizar(Integer codigo, Vendedor vendedor) {
		Vendedor vendedorExistente = vendedorRepository.findById(codigo)
				.orElseThrow(() -> new VendedorNotFoundException("Vendedor não encontrado com código: " + codigo));
		vendedorExistente.setUsuario(vendedor.getUsuario());
		return vendedorRepository.save(vendedorExistente);
	}

	@Override
	public void deletar(Integer codigo) {
		vendedorRepository.deleteById(codigo);
	}

	@Override
	public Vendedor buscarPorCodigo(Integer codigo) {
		return vendedorRepository.findById(codigo)
				.orElseThrow(() -> new VendedorNotFoundException("Vendedor não encontrado com código: " + codigo));
	}

	@Override
	public List<Vendedor> listarTodos() {
		return vendedorRepository.findAll();
	}

	@Override
	public Page<Vendedor> listarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
