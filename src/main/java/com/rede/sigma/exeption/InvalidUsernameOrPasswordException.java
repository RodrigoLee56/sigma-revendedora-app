package com.rede.sigma.exeption;

public class InvalidUsernameOrPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUsernameOrPasswordException(String message) {
		super(message);
	}

}
