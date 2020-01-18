package org.certificatic.spring.core.practica14.test.numericalConverter;

import java.text.DecimalFormat;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica14.numericalConverter.bean.NumericalConverter;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericalConverterTest {

	private static ClassPathXmlApplicationContext applicationContext;

	private DecimalFormat currencyFormat = new DecimalFormat(
			"$ ###,###,###.##");
	private DecimalFormat simpleNumberFormat = new DecimalFormat("#.##");

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica14/numerical-converter-application-context.xml");
	}

	@Test
	public void numericalConverterTest() {

		log.info("numericalConverterTest -------------------");

		// Obtener bean NumericalConverter
		NumericalConverter converter = applicationContext.getBean(NumericalConverter.class);
		
		// realizar test con Asserts
		Assert.assertThat(converter, CoreMatchers.is(CoreMatchers.notNullValue()));
		
		Assertions.assertThat(converter).isNotNull();
		Assertions.assertThat(converter.getCurrrency()).isNotNull();
		Assertions.assertThat(converter.getNumerical()).isNotNull();
		
		double number = Math.random() * 999_999_999;
		
		String numberString = simpleNumberFormat.format(number);
		
		String letterNumber = converter.convert(numberString, true);
		
		log.info("number: {}", currencyFormat.format(number));
		log.info("letter number: {}", letterNumber);

		((AbstractApplicationContext) applicationContext).close();
	}

}
