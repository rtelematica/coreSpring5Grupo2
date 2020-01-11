package org.certificatic.spring.core.practica11.test.innerbeans;

import org.certificatic.spring.core.practica11.innerbeans.bean.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InnerBeansTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica11/inner-beans-application-context.xml");
	}

	@After
	public void afterTest() {
		applicationContext.close();
	}

	@Test
	public void innerBeansTest() {

		log.info("innerBeansTest -------------------");

		Person person = applicationContext.getBean(Person.class);

		Assert.assertNotNull(person);

		log.info("person: {}", person);
	}

	@Test
	public void getStreetNameBeanTest() {

		log.info("getStreetNameBeanTest -------------------");

		String streetNameBean = applicationContext.getBean("streetNameBean", String.class);

		Assert.assertNotNull(streetNameBean);

		log.info("streetNameBean: {}", streetNameBean);
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getNameBeanTest() {

		log.info("getNameBeanTest -------------------");

		String nameBean = null;

		nameBean = applicationContext.getBean("nameBean", String.class);

		Assert.fail("Should have to fail at this line");

	}

}
