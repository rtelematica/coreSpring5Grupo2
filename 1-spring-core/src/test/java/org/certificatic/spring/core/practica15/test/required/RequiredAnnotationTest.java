package org.certificatic.spring.core.practica15.test.required;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.required.bean.Cameraman;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequiredAnnotationTest {

	@Test
	public void requiredAnnotationTest() {

		log.info("requiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);
		
		Cameraman cameraman = ctx.getBean("okCameraman", Cameraman.class);
		
		Assertions.assertThat(cameraman).isNotNull();
		Assertions.assertThat(cameraman.getDni()).isNotNull();
		Assertions.assertThat(cameraman.getName()).isNotNull();
		Assertions.assertThat(cameraman.getAge()).isNull();
		
		log.info("cameraman: {}", cameraman);
		
		ctx.close();
	}

	@Test(expected = BeanCreationException.class) // En Spring 5 @Required esta depreciada
	@Ignore
	public void badRequiredAnnotationTest() {

		log.info("badRequiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);
		
		Cameraman cameraman = ctx.getBean("badCameraman", Cameraman.class);
		
		Assertions.fail("Must fail at this point");
		
		ctx.close();
	}

}
