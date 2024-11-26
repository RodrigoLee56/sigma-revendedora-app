package com.rede.sigma.exeption;

public class OperacaoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OperacaoNotFoundException(String message) {
		super(message);
	}

}
