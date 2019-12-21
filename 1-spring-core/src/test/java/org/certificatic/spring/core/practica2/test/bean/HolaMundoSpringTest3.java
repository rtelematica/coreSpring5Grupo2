package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest3 {

	private static ApplicationContext factory;

	// Instanciar ApplicationContext Antes de ejecutar la clase de test
	@BeforeClass
	public static void beforeClass() {
		factory = new ClassPathXmlApplicationContext("spring/practica2/beans.xml");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Close application context");
	}

	@Test
	public void holaMundoSpringTest3a() {
		log.info("holaMundoSpringTest3a -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo hola1 = (HolaMundo) factory.getBean("hmb1");

		Assert.assertNotNull(hola1);
		Assert.assertNull(hola1.getMensaje());

		System.out.println(hola1);

	}
	
	@Test
	public void holaMundoSpringTest3b() {
		log.info("holaMundoSpringTest3b -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo hola2 = (HolaMundo) factory.getBean("hmb2");

		Assert.assertNotNull(hola2);
		Assert.assertNotNull(hola2.getMensaje());

		System.out.println(hola2);

	}
	
	@Test
	public void holaMundoSpringTest3c() {
		log.info("holaMundoSpringTest3c -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo hola3 = (HolaMundo) factory.getBean("hmb3");

		Assert.assertNotNull(hola3);
		Assert.assertNotNull(hola3.getMensaje());

		System.out.println(hola3);

	}
	
	@Test
	public void holaMundoSpringTest3d() {
		log.info("holaMundoSpringTest3d -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo hola4 = (HolaMundo) factory.getBean("hmb4");

		Assert.assertNotNull(hola4);
		Assert.assertNotNull(hola4.getMensaje());

		System.out.println(hola4);

	}
	
}
