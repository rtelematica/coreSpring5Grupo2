package org.certificatic.spring.core.practica20.test.resources;

import org.certificatic.spring.core.practica20.resources.bean.Resources;
import org.certificatic.spring.core.practica20.test.resources.utils.ResourcesTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
@RunWith(SpringRunner.class)
// cargar context configuration
@ContextConfiguration(locations = ResourcesTest.location)
public class ResourcesTest {

	public static final String location = "classpath:/spring/practica20/resources-application-context.xml";

	// Inyectar
	@Autowired
	private Resources resources;

	@Test
	public void loadTextFileClasspathXmlApplicationContextTest() {

		log.info("loadTextFileClasspathXmlApplicationContextTest -------------------");

		// loadTextFile
		Resource resource = resources.getTxtFile();
		
		ResourcesTestUtils.loadTextFile(resource);
	}

	@Test
	public void loadPropertiesFileClasspathXmlApplicationContextTest() {

		log.info("loadPropertiesFileClasspathXmlApplicationContextTest -------------------");

		// loadPropertiesFile
		Resource resource = resources.getPropertiesFile();
		
		ResourcesTestUtils.loadPropertiesFile(resource);
	}

	@Test
	public void loadUrlFileClasspathXmlApplicationContextTest() {

		log.info("loadUrlFileClasspathXmlApplicationContextTest -------------------");

		// loadURLFile
		Resource resource = resources.getUrlFile();
		
		ResourcesTestUtils.loadURLFile(resource);
	}

	@Test
	public void loadAndCopyImageFileClasspathXmlApplicationContextTest() {

		log.info("loadAndCopyImageFileClasspathXmlApplicationContextTest -------------------");

		// loadAndCopyImage
		Resource resource = resources.getImageFile();
		
		ResourcesTestUtils.loadAndCopyImage(resource,
				"src/main/resources/spring/practica20/copy-resources/");
	}
}
