package org.certificatic.spring.core.practica21.test.spel;

import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.QuadraticEquationResult;
import org.certificatic.spring.core.practica21.spel.bean.Chicharronera;
import org.certificatic.spring.core.practica21.spel.bean.GuessNumber;
import org.certificatic.spring.core.practica21.spel.bean.Magician;
import org.certificatic.spring.core.practica21.spel.bean.MyBeanResolver;
import org.certificatic.spring.core.practica21.spel.configuration.ApplicationConfig;
import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VariablesFunctionsBeanReferencesExpressionsTest_7 {
	
	@Data
	static class Perro {

		private String name;

		public Perro(String name) {
			this.name = name;
		}
		
	}
	
	@Data
	static class Gato {

		private String name;

		public Gato(String name) {
			this.name = name;
		}
		
	}

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static StandardEvaluationContext evaluationContext;

	private static ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		evaluationContext = new StandardEvaluationContext();
		
		// asignar al 'springContext' el bean resolver 'MyBeanResolver' que se encuentra en el application context
		MyBeanResolver mbr = applicationContext.getBean(MyBeanResolver.class);
		evaluationContext.setBeanResolver(mbr);
	}

	@Test
	public void perroGatoTest() {
		// asignar al 'springContext' el bean resolver 'MyBeanResolver' que se encuentra en el application context
		evaluationContext.setBeanResolver((EvaluationContext context, String beanName) -> {
			if(beanName.equals("perro"))
				return new Perro("Pancho");
			else
				return new Gato("Miau");
		});

		Perro perro = spelParser.parseExpression("@perro").getValue(evaluationContext, Perro.class);
		Assert.assertEquals("Pancho", perro.getName());
	}
	
	@Test
	public void variablesExpressionsTest() {

		log.info("variablesExpressionsTest -------------------");

		Magician magician = applicationContext.getBean(Magician.class);
		Magician magician2 = spelParser.parseExpression("@magicianBean")
											.getValue(evaluationContext, Magician.class);
		
		Assert.assertSame(magician, magician2);

		evaluationContext.setVariable("magicNumber", magician.getInitialNumber()); // solo analizar

		// definir y obtener el valor de una expresion que acceda al bean guessNumberBean definido en el aplication-context.xml
		// y recupere el valor de la propiedad randomNumber
		Integer randomNumber = spelParser.parseExpression("@guessNumberBean.randomNumber")
											.getValue(evaluationContext, Integer.class);

		evaluationContext.setVariable("randomNumber", randomNumber); // solo analizar

		// -------------------------------------

		Boolean isCorrectNumber = spelParser.parseExpression("#randomNumber == #magicNumber").getValue(evaluationContext,
				Boolean.class); // solo analizar
		
		Assert.assertNotNull(isCorrectNumber);
		Assert.assertTrue(isCorrectNumber);
		
		log.info("isCorrectNumber: {}", isCorrectNumber);

		log.info("magician.initialNumber: {}", magician.getInitialNumber());
		
		log.info("gessNumberBean.randomNumber: {}", randomNumber);
	}

	@Test
	@SneakyThrows
	public void functionsExpressionsTest() {

		log.info("functionsExpressionsTest -------------------");

		// analizar setVariable's
		evaluationContext.setVariable("a", 2);
		evaluationContext.setVariable("b", 3);
		evaluationContext.setVariable("c", -5);

		// registra una funcion llamada 'chicharronera' que invoque al metodo 'calculate' de la clase Chicharronera
		Class[] parameterTypes = new Class[] {double.class, double.class, double.class};
		evaluationContext.registerFunction("chicharronera",
				Chicharronera.class.getDeclaredMethod("calculate", parameterTypes));

		QuadraticEquationResult expectedResult = QuadraticEquationResult.builder()
				.x1(new Complex(1, 0.0))
				.x2(new Complex(-2.5, 0.0)).build(); // solo analiza

		// definir y obtener el valor de la expresion que invoque a la funcion 'chicharronera' tomando como argumentos
		// las variables 'a', 'b' y 'c'
		QuadraticEquationResult quadraticEquationResult = spelParser
								.parseExpression("#chicharronera(#a, #b, #c)")
								.getValue(evaluationContext, QuadraticEquationResult.class);

		Assert.assertNotNull(quadraticEquationResult);
		
		Assert.assertEquals(expectedResult, quadraticEquationResult);
		
		log.info("quadraticEquationResult: {}", quadraticEquationResult);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void beanReferencesExpressionsTest() {

		log.info("beanReferencesExpressionsTest -------------------");

		GuessNumber guessNumber = spelParser.parseExpression("@guessNumberBean").getValue(evaluationContext,
				GuessNumber.class); //solo analiza
		
		Assert.assertNotNull(guessNumber);
		
		log.info("guessNumber: {}", guessNumber);

		// -------------------------------------

		Inventor tesla = spelParser.parseExpression("@teslaBean").getValue(evaluationContext,
				Inventor.class); //solo analiza
		
		Assert.assertNotNull(tesla);
		
		log.info("tesla: {}", tesla);

		// -------------------------------------

		Integer inventionsLength = spelParser.parseExpression("@teslaBean.inventions.length").getValue(evaluationContext,
				int.class); //solo analiza
		
		Assert.assertNotNull(inventionsLength);
		
		log.info("inventionsLength: {}", inventionsLength);

		// -------------------------------------

		List<String> inventions = spelParser.parseExpression("@teslaBean.inventions").getValue(evaluationContext,
				List.class); //solo analiza
		
		Assert.assertNotNull(inventions);
		
		log.info("inventions: {}", inventions);

		Assert.assertEquals(3, inventions.size());
	}

}
