package org.certificatic.spring.core.practica15.test.autowired.setter;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredSetterAnnotationTest {

	@Test
	public void autowiredSetterAnnotationTest() {

		log.info("autowiredSetterAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-setter-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Journalist journalist = ctx.getBean(Journalist.class);

		Assertions.assertThat(journalist).isNotNull();
		Assertions.assertThat(journalist.getName()).isNotNull();
		Assertions.assertThat(journalist.getAge()).isNotNull();
		Assertions.assertThat(journalist.getNotebook()).isNotNull();
		Assertions.assertThat(journalist.getPen()).isNotNull();

		Assertions.assertThat(journalist.getDni()).isNull();

		log.info("journalist: {}", journalist);

		ctx.close();
	}

}
