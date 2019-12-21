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
public class ThreadScopeSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		System.out.println("no se ha construido nada");
		applicationContext = new ClassPathXmlApplicationContext("spring/practica5/scopes-application-context.xml");
		System.out.println("ya se construyeron los bean singleton");
	}

	@Test
	public void threadScopesSpringTest() {

		log.info("threadScopesSpringTest -------------------");

		// Implementar
		for (int i = 0; i < 3; i++) {
			Persona persona = applicationContext.getBean("personaThreadScopeBean", 
																		Persona.class);

			Assert.assertNotNull(persona);

			log.info("persona: {}, {}, {}", persona, persona.hashCode(), 
														System.identityHashCode(persona));
		}
	}
	
	@Test
	public void threadScopesSpringTest2() {

		log.info("threadScopesSpringTest2 -------------------");

		// Implementar
		for (int i = 0; i < 3; i++) {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Persona persona = applicationContext.getBean("personaThreadScopeBean", 
							Persona.class);
					
					Persona persona2 = applicationContext.getBean("personaThreadScopeBean", 
							Persona.class);

					Assert.assertNotNull(persona);
					Assert.assertNotNull(persona2);
					
					System.out.println(Thread.currentThread().getName() + 
							" persona: " + persona + " "+ persona.hashCode() + " " +
							System.identityHashCode(persona));
					
					System.out.println(Thread.currentThread().getName() + 
							" persona2: " + persona2 + " "+ persona2.hashCode() + " " +
							System.identityHashCode(persona2));
				}
			}).start();
			
		}
	}

	
	
}
