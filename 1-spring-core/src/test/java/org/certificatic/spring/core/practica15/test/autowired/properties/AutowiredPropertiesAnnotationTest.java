package org.certificatic.spring.core.practica15.test.autowired.properties;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.autowired.properties.bean.Reporter;
import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredPropertiesAnnotationTest {

	@Test
	public void autowiredPropertiesAnnotationTest() {

		log.info("autowiredPropertiesAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-property-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Reporter reporter = ctx.getBean(Reporter.class);

		Assertions.assertThat(reporter).isNotNull();
		Assertions.assertThat(reporter.getName()).isNotNull();
		Assertions.assertThat(reporter.getAge()).isNotNull();
		Assertions.assertThat(reporter.getNotebook()).isNotNull();
		Assertions.assertThat(reporter.getPen()).isNotNull();

		Assertions.assertThat(reporter.getDni()).isNull();

		log.info("reporter: {}", reporter);

		ctx.close();
	}

}
