package org.certificatic.spring.core.practica15.test.autowired.requiredFalse.qualifier;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.autowired.requiredFalse.qualifier.bean.Airplane;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredRequredFalseQualifierAnnotationTest {

	@Test
	public void autowiredPropertiesAnnotationTest() {

		log.info("autowiredPropertiesAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-requiredFalse-qualifier-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Airplane airplane = ctx.getBean(Airplane.class);

		Assertions.assertThat(airplane).isNotNull();
		Assertions.assertThat(airplane.getAirplaneCode()).isNull();
		Assertions.assertThat(airplane.getCapitanName()).isNotNull();
		Assertions.assertThat(airplane.getCapitanName()).isEmpty();
		Assertions.assertThat(airplane.getCapitanName().isPresent()).isFalse();
		Assertions.assertThat(airplane.getTotalPassengerSeats()).isNull();
		Assertions.assertThat(airplane.getAirline()).isNotNull();

		log.info("airplane: {}", airplane);

		ctx.close();
	}
}
