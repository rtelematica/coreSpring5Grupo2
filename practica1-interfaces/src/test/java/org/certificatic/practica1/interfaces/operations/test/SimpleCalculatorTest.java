package org.certificatic.practica1.interfaces.operations.test;

import java.text.DecimalFormat;

import org.certificatic.practica1.interfaces.operations.api.IKidsCalculator;
import org.certificatic.practica1.interfaces.operations.api.ISimpleCalculator;
import org.certificatic.practica1.interfaces.operations.api.impl.KidsCalculator;
import org.certificatic.practica1.interfaces.operations.api.impl.SimpleCalculator;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleCalculatorTest {

	private DecimalFormat df = new DecimalFormat("#.00##");

	@Test
	public void simpleCalculatorTest() {
		log.info("simpleCalculatorTest -------------------");

		// Implementar
		ISimpleCalculator simpleCalculator = new SimpleCalculator();
		double result = simpleCalculator.set(5).multiply(3).add(10).add(20).subtract(15).divide(10).result();
		
		Assert.assertEquals(3, result, 0.00001);
	}

}
