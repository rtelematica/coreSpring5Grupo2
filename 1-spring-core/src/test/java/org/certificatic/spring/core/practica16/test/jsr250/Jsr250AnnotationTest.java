package org.certificatic.spring.core.practica16.test.jsr250;

import org.assertj.core.api.Assertions;
import org.certificatic.spring.core.practica16.jsr250.bean.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Jsr250AnnotationTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica16/annotations-jsr250-application-context.xml");
	}

	@AfterClass
	public static void afterClass() {
		applicationContext.close();
	}

	@Test
	public void jsr250AnnotationTest() {

		log.info("jsr250AnnotationTest -------------------");

		// Implementar
		Student student = applicationContext.getBean(Student.class);

		Assertions.assertThat(student).isNotNull();
		Assertions.assertThat(student.getName()).isNotNull();
		Assertions.assertThat(student.getEnrollment()).isNotNull();
		Assertions.assertThat(student.getSubject()).isNotNull();
		Assertions.assertThat(student.getSubject().getName()).isEqualTo("Algebra III");
		Assertions.assertThat(student.getMathematics().getName()).isEqualTo("Mathematics");
		
		log.info("student: {}", student);
	}

}
