package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoNoSpringTest {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		// Crear instancia de HolaMundo
		HolaMundo hola = null;
		
		Assert.assertNull(hola);
		
		System.out.println(hola);
		
		// Instanciar
		hola = new HolaMundo();
		
		Assert.assertNotNull(hola);
		Assert.assertNull(hola.getMensaje()); 
		
		System.out.println(hola);
		
		// Inyeccion por setter
		hola.setMensaje("mi mensaje");
		
		Assert.assertNotNull(hola.getMensaje());
		
		System.out.println(hola);
		
		// Instanciar e inyectar dependencia por constructor
		HolaMundo hola2 = new HolaMundo("mi otro mensaje");
		
		Assert.assertNotNull(hola2);
		Assert.assertNotNull(hola2.getMensaje()); 
		
		System.out.println(hola2);

	}
}
