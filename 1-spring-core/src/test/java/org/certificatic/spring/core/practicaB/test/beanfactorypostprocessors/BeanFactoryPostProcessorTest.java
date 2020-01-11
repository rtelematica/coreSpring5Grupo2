package org.certificatic.spring.core.practicaB.test.beanfactorypostprocessors;

import org.certificatic.spring.core.practicaB.beanfactorypostprocessors.bean.Welcome;
import org.certificatic.spring.core.practicaB.beanfactorypostprocessors.bfpp.WelcomeBeanFactoryPostProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanFactoryPostProcessorTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practicaB/bean-factory-post-processors-application-context.xml");
	}

	@After
	public void afterTest() {
		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void beanFactoryPostProcessorsTest() {

		log.info("beanFactoryPostProcessorsTest -------------------");

		Welcome welcomeBean = applicationContext.getBean(Welcome.class);

		Assert.assertNotNull(welcomeBean);

		welcomeBean.welcome();

		Assert.assertNotEquals("saludo", welcomeBean.getGreetingsText());

//		if (WelcomeBeanFactoryPostProcessor.nowIsAfternoon()) {
//			Assert.assertEquals(WelcomeBeanFactoryPostProcessor.GOOD_AFTERNOON, welcomeBean.getGreetingsText());
//		} else {
//			Assert.assertEquals(WelcomeBeanFactoryPostProcessor.GOOD_MORNING, welcomeBean.getGreetingsText());
//		}
	}

}
