package org.certificatic.spring.core.practica21.test.spel;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplatingExpressionsTest_9 {

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static StandardEvaluationContext context;

	@BeforeClass
	public static void setUp() {
		context = new StandardEvaluationContext();
	}

	@Test
	public void templatingExpressionsTest() {

		log.info("templatingExpressionsTest -------------------");

		context.setVariable("name", "Ivan Garcia");

		String greeting = spelParser
				.parseExpression("Hi #{ #name +' '+'you''re' } awesome!", new TemplateParserContext())
				.getValue(context, String.class); // solo analiza

		Assert.assertNotNull(greeting);

		Assert.assertEquals("Hi Ivan Garcia you're awesome!", greeting);

		log.info("greeting: {}", greeting);
	}

	@Test
	public void templatingExpressionsTest2() {

		log.info("templatingExpressionsTest2 -------------------");

		context.setVariable("name", "Ivan Garcia");

		String greeting = spelParser
				.parseExpression("Hi %[[ #name +' '+'you''re' ]] awesome!", new TemplateParserContext("%[[", "]]"))
				.getValue(context, String.class); // solo analiza

		Assert.assertNotNull(greeting);

		Assert.assertEquals("Hi Ivan Garcia you're awesome!", greeting);

		log.info("greeting: {}", greeting);
	}

}
