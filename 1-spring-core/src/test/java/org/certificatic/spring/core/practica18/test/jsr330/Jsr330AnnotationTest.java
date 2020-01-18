package org.certificatic.spring.core.practica18.test.jsr330;

import static org.assertj.core.api.Assertions.contentOf;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica18.jsr330.bean.Corporation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
@RunWith(SpringRunner.class)
// cargar context configuration
@ContextConfiguration("classpath:/spring/practica18/annotations-jsr330-application-context.xml")
public class Jsr330AnnotationTest {

	// Inyectar
	@Autowired
	private Corporation corporation;

	@Before
	public void beforeClass() {
		Assert.assertNotNull(corporation);
	}

	@Test
	public void jsr330AnnotationTest() {

		log.info("jsr330AnnotationTest -------------------");

		log.info("corporation: {}", corporation);

		Assertions.assertThat(corporation.getItDirector()).isNotNull();
		Assertions.assertThat(corporation.getItDirector().getEmployee()).isNotNull();
		Assertions.assertThat(corporation.getGeneralDirector()).isNotNull();
		Assertions.assertThat(corporation.getGeneralDirector().getEmployee()).isNotNull();
		
		Assertions.assertThat(corporation.getSecretaryAssistant()).isNotNull();
		Assertions.assertThat(corporation.getSecretaryAssistant()
											.getEmployee()).isNotNull();
		Assertions.assertThat(corporation.getSecretaryAssistant()
											.getEmployee().getName()).isEqualTo("Alejandra Moras");
		
		Assertions.assertThat(corporation.getGeneralSecretary()).isEmpty();
		Assertions.assertThat(corporation.getGeneralSecretaryMirror()).isNull();
		
		Assertions.assertThat(corporation.getManager()).isNotNull();
		Assertions.assertThat(corporation.getManager().getEmployee()).isNotNull();
		Assertions.assertThat(corporation.getManager().getTeam1()).isNotNull();
		Assertions.assertThat(corporation.getManager().getTeam2()).isNotNull();
		
		Assertions.assertThat(corporation.getManager().getTeam1())
			.isNotEqualTo(corporation.getManager().getTeam2());	
		
	}

}
