package com.rede.sigma.exeption;

public class PedidoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PedidoNotFoundException(String message) {
		super(message);
	}

}
