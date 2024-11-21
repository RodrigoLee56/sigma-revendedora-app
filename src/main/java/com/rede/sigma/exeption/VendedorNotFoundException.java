package com.rede.sigma.exeption;

public class VendedorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VendedorNotFoundException(String message) {
		super(message);
	}
}
