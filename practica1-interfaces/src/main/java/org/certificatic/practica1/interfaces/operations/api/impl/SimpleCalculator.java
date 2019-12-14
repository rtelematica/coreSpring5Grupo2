package org.certificatic.practica1.interfaces.operations.api.impl;

import org.certificatic.practica1.interfaces.operations.api.ISimpleCalculator;

public class SimpleCalculator extends    Calculator<ISimpleCalculator> 
							  implements ISimpleCalculator {

	@Override
	public ISimpleCalculator add(double number) {
		this.acumulador += number;
		return this;
	}

	@Override
	public ISimpleCalculator subtract(double number) {
		this.acumulador -= number;
		return this;
	}

	@Override
	public ISimpleCalculator multiply(double number) {
		this.acumulador *= number;
		return this;
	}

	@Override
	public ISimpleCalculator divide(double number) {
		this.acumulador /= number;
		return this;
	}
}