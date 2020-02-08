package org.certificatic.spring.core.practicaD.test.propertysource;

import org.certificatic.spring.core.practicaD.propertysource.config.PropertySourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PropertySourceConfig.class)
public class PropertySourceTest {

	// Inyecta
	@Autowired
	private Environment env;

	// Inyecta propiedad my.app-name
	@Value("${my.app-name}")
	private String myAppName;

	// Inyecta propiedad my.app2-name
	@Value("${my.app2-name}")
	private String myApp2Name;
	
	// Inyecta propiedad perro.name
	@Value("${perro.name:Fido}")
	private String perroName;

	@Before
	public void setUp() {
		Assert.assertNotNull(env);
	}

	@Test
	public void propertySourceTest1() {

		log.info("propertySourceTest1 -------------------");

		log.info("environment = {}", env);

		log.info("env.getProperty(\"my.app-name\") = {}", env.getProperty("my.app-name"));
		log.info("env.getProperty(\"my.app2-name\") = {}", env.getProperty("my.app2-name"));

		log.info("my app name = {}", myAppName);
		log.info("my app 2 name = {}", myApp2Name);

		Assert.assertEquals("Wonderful Application", myAppName);
		Assert.assertEquals(myAppName, env.getProperty("my.app-name"));
		
		Assert.assertEquals("Wonderful Application 2", myApp2Name);
		Assert.assertEquals(myApp2Name, env.getProperty("my.app2-name"));
		
		Assert.assertEquals("Fido", perroName);

		log.info("-------");
	}

}
