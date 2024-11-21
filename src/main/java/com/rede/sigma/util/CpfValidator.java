package com.rede.sigma.util;

public class CpfValidator {

	public static boolean isValid(String cpf) {

		if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
			return false;
		}

		int[] weights = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		int primeiroDigito = calculaDigito(cpf.substring(0, 9), weights);
		int segundoDigito = calculaDigito(cpf.substring(0, 9) + primeiroDigito, weights);

		return cpf.equals(cpf.substring(0, 9) + primeiroDigito + segundoDigito);
	}

	private static int calculaDigito(String str, int[] weights) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i)) * weights[i];
		}
		int remainder = sum % 11;
		return remainder < 2 ? 0 : 11 - remainder;
	}
}
