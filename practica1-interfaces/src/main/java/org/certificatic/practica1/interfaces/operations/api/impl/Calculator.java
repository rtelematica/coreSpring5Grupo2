package org.certificatic.practica1.interfaces.operations.api.impl;

import org.certificatic.practica1.interfaces.operations.api.ICalculator;

public class Calculator<K> implements ICalculator<K> {

	// Implementar
	protected double acumulador;

	@Override
	public K set(double number) {
		this.acumulador = number;
		return (K) this;
	}

	@Override
	public double result() {
		return acumulador;
	}
}
