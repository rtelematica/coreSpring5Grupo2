package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest1 {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		String ruta = "spring/practica2/beans.xml";

		// Implementar IoC con BeanFactory
		ClassPathResource resource = new ClassPathResource(ruta);
		BeanFactory factory = new XmlBeanFactory(resource);

		HolaMundo hola1 = (HolaMundo) factory.getBean("hmb1");

		Assert.assertNotNull(hola1);
		Assert.assertNull(hola1.getMensaje());

		System.out.println(hola1);

		HolaMundo hola2 = (HolaMundo) factory.getBean("hmb2");

		Assert.assertNotNull(hola2);
		Assert.assertNotNull(hola2.getMensaje());

		System.out.println(hola2);

		HolaMundo hola3 = (HolaMundo) factory.getBean("hmb3");

		Assert.assertNotNull(hola3);
		Assert.assertNotNull(hola3.getMensaje());

		System.out.println(hola3);
		
		HolaMundo hola4 = (HolaMundo) factory.getBean("hmb4");

		Assert.assertNotNull(hola4);
		Assert.assertNotNull(hola4.getMensaje());

		System.out.println(hola4);

	}
}
