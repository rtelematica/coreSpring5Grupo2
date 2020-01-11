package org.certificatic.spring.core.practica8.test.factorymethod;

import org.certificatic.spring.core.practica8.factorymethod.bean.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryMethodTest {

	private static ApplicationContext applicationContext;

	@Before
	public void beforeMethod() {
		// Instanciar ApplicationContext
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica8/factory-method-application-context.xml");
	}

	@After
	public void afterMethod() {
		((ConfigurableApplicationContext) applicationContext).close();
	}

	@Test
	public void factoryMethodTest() {

		log.info("factoryMethodTest -------------------");

		// Implementar
		Student student = applicationContext.getBean("student1",Student.class);

		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getName());
		Assert.assertEquals("Ivan Garcia", student.getName());

		log.info("student: {}", student);

		log.info("factoryMethodTest -------------------");
	}

	@Test
	public void factoryMethodTest2() {

		log.info("factoryMethodTest2 -------------------");

		// Implementar
		Student student = applicationContext.getBean("student2", Student.class);

		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getName());
		Assert.assertEquals("Pepe Garcia", student.getName());

		log.info("student: {}", student);

		log.info("factoryMethodTest2 -------------------");
	}

}
