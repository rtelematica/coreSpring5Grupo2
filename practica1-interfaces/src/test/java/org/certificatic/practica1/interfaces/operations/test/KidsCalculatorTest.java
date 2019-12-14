package org.certificatic.practica1.interfaces.operations.test;

import java.text.DecimalFormat;

import org.certificatic.practica1.interfaces.operations.api.IKidsCalculator;
import org.certificatic.practica1.interfaces.operations.api.impl.KidsCalculator;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KidsCalculatorTest {

	private DecimalFormat df = new DecimalFormat("#.00##");

	@Test
	public void kidsCalculatorTest() {
		log.info("kidsCalculatorTest -------------------");

		// Implementar
		IKidsCalculator kidsCalculator = new KidsCalculator();
		double result = kidsCalculator.set(5).add(10).add(20).subtract(15).result();
		
		Assert.assertEquals(20, result, 0.00001);
	}

}
