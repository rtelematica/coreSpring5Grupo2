package org.certificatic.spring.core.practica15.test.autowired.constructor;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.autowired.constructor.bean.Engineer;
import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredConstructorAnnotationTest {

	@Test
	public void autowiredConstructorAnnotationTest() {

		log.info("autowiredConstructorAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-constructor-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Engineer engineer = ctx.getBean(Engineer.class);

		Assertions.assertThat(engineer).isNotNull();
		Assertions.assertThat(engineer.getName()).isNotNull();
		Assertions.assertThat(engineer.getAge()).isNotNull();
		Assertions.assertThat(engineer.getNotebook()).isNotNull();
		Assertions.assertThat(engineer.getPen()).isNotNull();

		Assertions.assertThat(engineer.getDni()).isNull();

		log.info("engineer: {}", engineer);

		ctx.close();
	}

}
