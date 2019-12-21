package org.certificatic.spring.core.practica5.test.scopes;

import org.certificatic.spring.core.practica3.jugador.api.IJugador;
import org.certificatic.spring.core.practica5.scopes.bean.Persona;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScopesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		System.out.println("no se ha construido nada");
		applicationContext = new ClassPathXmlApplicationContext("spring/practica5/scopes-application-context.xml");
		System.out.println("ya se construyeron los bean singleton");
	}

	@Test
	public void customScopesSpringTest() {

		log.info("scopeSingletonSpringTest -------------------");

		// Implementar
		for (int i = 0; i < 35; i++) {
			Persona persona = applicationContext.getBean("personaCustomScopeBean", 
																		Persona.class);

			Assert.assertNotNull(persona);

			log.info("persona: {}, {}, {}", persona, persona.hashCode(), 
														System.identityHashCode(persona));
		}
	}
	
	@Test
	public void customScopesSpringTest2() {

		log.info("scopeSingletonSpringTest2 -------------------");

		// Implementar
		for (int i = 0; i < 11; i++) {
			IJugador jugador = applicationContext.getBean("jugadorCustomScopeBean", 
																		IJugador.class);

			Assert.assertNotNull(jugador);

			log.info("persona: {}, {}, {}", jugador, jugador.hashCode(), 
														System.identityHashCode(jugador));
		}
	}

	
	
}
