package com.rede.sigma.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<String> handleClienteNotFoundException(ClienteNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado: " + ex.getMessage());
	}

	@ExceptionHandler(VeiculoNotFoundException.class)
	public ResponseEntity<String> handleVeiculoNotFoundException(VeiculoNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado: " + ex.getMessage());
	}

	@ExceptionHandler(VendedorNotFoundException.class)
	public ResponseEntity<String> handleVendedorNotFoundException(VendedorNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor não encontrado: " + ex.getMessage());
	}

	@ExceptionHandler(MontadoraNotFoundException.class)
	public ResponseEntity<String> handleMontadoraNotFoundException(MontadoraNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Montadora não encontrada: " + ex.getMessage());
	}

	@ExceptionHandler(OperacaoNotFoundException.class)
	public ResponseEntity<String> handleOperacaoNotFoundException(OperacaoNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operacao não encontrada: " + ex.getMessage());
	}

	@ExceptionHandler(PedidoNotFoundException.class)
	public ResponseEntity<String> handlePedidoNotFoundException(PedidoNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado: " + ex.getMessage());
	}

	@ExceptionHandler(InvalidCpfException.class)
	public ResponseEntity<String> handleInvalidCpfException(InvalidCpfException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF inválido: " + ex.getMessage());
	}
}
