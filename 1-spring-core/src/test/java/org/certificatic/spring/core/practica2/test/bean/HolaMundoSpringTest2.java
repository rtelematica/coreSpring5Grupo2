package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest2 {

	@Test
	public void holaMundoSpringTest2() {
		log.info("holaMundoSpringTest2 -------------------------");

		String ruta = "spring/practica2/beans.xml";

		// Implementar IoC con ApplicationContext
		ApplicationContext factory = new ClassPathXmlApplicationContext(ruta);

		HolaMundo hola1 = (HolaMundo) factory.getBean("hmb1");
		HolaMundo hola11 = (HolaMundo) factory.getBean("hmb1");
		HolaMundo hola111 = (HolaMundo) factory.getBean("hmb1");

		Assert.assertSame(hola1, hola11);
		Assert.assertSame(hola11, hola111);
		Assert.assertSame(hola1, hola111);

		HolaMundo hola2 = (HolaMundo) factory.getBean("hmb2");
		HolaMundo hola22 = (HolaMundo) factory.getBean("hmb2");
		HolaMundo hola222 = (HolaMundo) factory.getBean("hmb2");

		Assert.assertSame(hola2, hola22);
		Assert.assertSame(hola22, hola222);
		Assert.assertSame(hola2, hola222);

		HolaMundo hola3 = (HolaMundo) factory.getBean("hmb3");
		HolaMundo hola33 = (HolaMundo) factory.getBean("hmb3");
		HolaMundo hola333 = (HolaMundo) factory.getBean("hmb3");

		Assert.assertSame(hola3, hola33);
		Assert.assertSame(hola33, hola333);
		Assert.assertSame(hola3, hola333);

		HolaMundo hola4 = (HolaMundo) factory.getBean("hmb4");
		HolaMundo hola44 = (HolaMundo) factory.getBean("hmb4");
		HolaMundo hola444 = (HolaMundo) factory.getBean("hmb4");

		Assert.assertSame(hola4, hola44);
		Assert.assertSame(hola44, hola444);
		Assert.assertSame(hola4, hola444);

	}
}
