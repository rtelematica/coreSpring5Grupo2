package org.certificatic.spring.core.practica15.test.autowired.methods;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica15.autowired.methods.bean.Student;
import org.certificatic.spring.core.practica15.autowired.properties.bean.Reporter;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredMethodsAnnotationTest {

	@Test
	public void autowiredMethodsAnnotationTest() {

		log.info("autowiredMethodsAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-methods-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Student student = ctx.getBean(Student.class);

		Assertions.assertThat(student).isNotNull();
		Assertions.assertThat(student.getName()).isNotNull();
		Assertions.assertThat(student.getAge()).isNotNull();
		Assertions.assertThat(student.getNotebook()).isNotNull();
		Assertions.assertThat(student.getPen()).isNotNull();

		Assertions.assertThat(student.getDni()).isNull();

		log.info("student: {}", student);

		ctx.close();
	}

}
