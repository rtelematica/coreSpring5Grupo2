package org.certificatic.spring.core.practicaA.test.lifecycle;

import org.certificatic.spring.core.practicaA.lifecycle.bean.Automovil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifecycleTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext();
		applicationContext.setConfigLocation("spring/practicaA/lifecycle-application-context.xml");

		applicationContext.refresh();
	}

	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) applicationContext).registerShutdownHook();
	}

	@Test
	public void lifecycleTest() {

		log.info("lifecycleTest -------------------");

		Automovil automovil = applicationContext.getBean(Automovil.class);

		automovil.run();
	}

}
