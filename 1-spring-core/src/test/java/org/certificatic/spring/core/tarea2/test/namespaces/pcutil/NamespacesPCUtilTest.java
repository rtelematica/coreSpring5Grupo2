package org.certificatic.spring.core.tarea2.test.namespaces.pcutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Agenda;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Auto;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Circulo;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.MisProperties;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Persona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NamespacesPCUtilTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/tarea2/namespaces-p-c-util-application-context.xml");
	}

	@Test
	public void collectionsTest() {

		log.info("collectionsTest -------------------");

		Persona persona = applicationContext.getBean(Persona.class);

		Assert.assertNotNull(persona);
		Assert.assertEquals("Ivan Garcia", persona.getNombre());

		log.info("persona: {}", persona);

		Circulo circulo = applicationContext.getBean(Circulo.class);

		Assert.assertNotNull(circulo);
		Assert.assertEquals(Math.PI * circulo.getRadio() * circulo.getRadio(), circulo.getArea(), 0.00001);

		log.info("circulo: {}", circulo);

		Agenda agenda = applicationContext.getBean(Agenda.class);

		Assert.assertNotNull(agenda);
		Assert.assertEquals("Spring Framework 5", agenda.getProperties().get("curso.nombre"));
		Assert.assertEquals(expectedNumerosMap(), agenda.getNumeros());
		Assert.assertEquals(expectedAutosFamiliaSet(), agenda.getAutosFamilia());
		Assert.assertEquals(expectedNotasList(), agenda.getNotas());

		log.info("agenda: {}", agenda);

		MisProperties misProperties = applicationContext.getBean(MisProperties.class);

		Assert.assertNotNull(misProperties);
		Assert.assertEquals("Ivan Garcia", misProperties.getProgrammerName());
		Assert.assertEquals("Iker Emilio", misProperties.getNombreHijo());
		Assert.assertEquals("Spring Framework 5", misProperties.getNombreCurso());

		log.info("misProperties: {}", misProperties);

		((AbstractApplicationContext) applicationContext).close();
	}

	private List<String> expectedNotasList() {
		List<String> lista = new ArrayList<>();
		lista.add("una nota");
		lista.add("dos notas");
		lista.add("tres notas");
		return lista;
	}

	private Set<Auto> expectedAutosFamiliaSet() {
		Set<Auto> autoSet = new HashSet<>();
		autoSet.add(new Auto("BMW", "330ia"));
		autoSet.add(new Auto("Ford", "Mustang GT"));
		return autoSet;
	}

	private Map<String, Integer> expectedNumerosMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("uno", 1);
		map.put("dos", 2);
		map.put("tres", 3);
		return map;
	}

}
