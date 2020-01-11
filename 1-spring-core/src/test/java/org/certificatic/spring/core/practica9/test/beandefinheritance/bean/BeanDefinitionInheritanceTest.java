package org.certificatic.spring.core.practica9.test.beandefinheritance.bean;

import org.certificatic.spring.core.practica9.beandefinitioninheritance.bean.ConnectionDataBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanDefinitionInheritanceTest {

	@Test
	public void beanDefinitionInheritanceTest1() {

		// Implementar
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica9/bean-def-inheritance-application-context.xml");

		log.info("beanDefinitionInheritanceTest1 -------------------");

		ConnectionDataBase connectionProd = applicationContext.getBean("connectionProdBean", ConnectionDataBase.class);

		Assert.assertNotNull(connectionProd);
		Assert.assertNotNull(connectionProd.getDatabase());
		Assert.assertNotNull(connectionProd.getPassword());
		Assert.assertFalse(connectionProd.isDebugMode());

		connectionProd.showInfo();

		ConnectionDataBase connectionTest = applicationContext.getBean("connectionTestBean", ConnectionDataBase.class);

		Assert.assertNotNull(connectionTest);
		Assert.assertNotNull(connectionTest.getDatabase());
		Assert.assertNotNull(connectionTest.getPassword());
		Assert.assertTrue(connectionTest.isDebugMode());

		connectionTest.showInfo();

		log.info("beanDefinitionInheritanceTest1 -------------------");

		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void beanDefinitionInheritanceTest2() {

		// Implementar
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica9/bean-def-inheritance-application-context2.xml");

		log.info("beanDefinitionInheritanceTest2 -------------------");

		ConnectionDataBase connectionProd = applicationContext.getBean("connectionProdBean", ConnectionDataBase.class);

		Assert.assertNotNull(connectionProd);
		Assert.assertNotNull(connectionProd.getDatabase());
		Assert.assertNotNull(connectionProd.getPassword());
		Assert.assertFalse(connectionProd.isDebugMode());

		connectionProd.showInfo();

		ConnectionDataBase connectionTest = applicationContext.getBean("connectionTestBean", ConnectionDataBase.class);

		Assert.assertNotNull(connectionTest);
		Assert.assertNotNull(connectionTest.getDatabase());
		Assert.assertNotNull(connectionTest.getPassword());
		Assert.assertTrue(connectionTest.isDebugMode());

		connectionTest.showInfo();

		log.info("beanDefinitionInheritanceTest2 -------------------");

		((AbstractApplicationContext) applicationContext).close();
	}

}
