package org.certificatic.spring.data.practicaH.test.jpa;

import java.util.Arrays;

import org.certificatic.spring.data.practicaH.jpa._config.SpringDataJpaConfiguration;
import org.certificatic.spring.data.practicaH.jpa.entity.Course;
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

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Test
	public void courseExample() {

		log.info("courseExample test starts =======================================================");

		// busca todos los cursos
		courseRepository.findAll().forEach(
				c -> System.out.println("course: "+c));
		
		System.out.println();

		// busca  los instructores con lastname Black
		System.out.println("Course of Instructor LastName Black");
		courseRepository.findByInstructorMemberLastName("Black").forEach(
				c -> System.out.println("Instructor lastName 'Black' course: "+c));
		
		// busca los instructores por nombre del curso
		System.out.println("Instructor of English 101 Course");
		staffRepository.findInstructorByCourseName("English 101").forEach(
				s -> System.out.println("Instructor of 'English 101' course: "+s));
		
		// busca los instructores por nombre del curso (recibe una lista de cursos)
		System.out.println("Instructor of English 101 and English 201 and English 202 Course");
		staffRepository.findInstructorByCourseNames(
				Arrays.asList("English 101","English 201", "English 202"))
				.forEach(
				s -> {
					System.out.println("Instructor of course: "+s);
				});

		log.info("courseExample test ends =======================================================");
	}

}