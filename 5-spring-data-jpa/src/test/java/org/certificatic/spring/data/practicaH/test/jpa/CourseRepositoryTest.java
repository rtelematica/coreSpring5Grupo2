package org.certificatic.spring.data.practicaH.test.jpa;

import java.util.Arrays;

import org.certificatic.spring.data.practicaH.jpa._config.SpringDataJpaConfiguration;
import org.certificatic.spring.data.practicaH.jpa.repositories.CourseRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ActiveProfiles("init-database")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = SpringDataJpaConfiguration.class)
public class CourseRepositoryTest {

	//@Autowired
	//private CourseRepository courseRepository;

	//@Autowired
	//private StaffRepository staffRepository;

	@Test
	public void courseExample() {

		log.info("courseExample test starts =======================================================");

		// busca todos los cursos
		
		System.out.println();

		// busca  los instructores con lastname Black
		
		// busca los instructores por nombre del curso (recibe una lista de cursos)
		
		// busca los instructores por nombre del curso

		log.info("courseExample test ends =======================================================");
	}

}