package org.certificatic.spring.core.practicaA.test.lifecycle;

import org.certificatic.spring.core.practicaA.lifecycle.bean.Automovil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifecycleTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext();
	}

	@Test
	public void lifecycleTest() {

		log.info("lifecycleTest -------------------");

		Automovil automovil = applicationContext.getBean(Automovil.class);

		log.info("automovil: {}", automovil);

		automovil.run();

		((AbstractApplicationContext) applicationContext).registerShutdownHook();

		log.info("automovil: {}", automovil);
	}

}
