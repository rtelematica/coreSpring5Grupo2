package org.certificatic.spring.data.practicaH.test.jpa.demo;

import java.time.LocalDate;
import java.util.Optional;

import org.certificatic.spring.data.practicaH.jpa._config.SpringDataJpaConfiguration;
import org.certificatic.spring.data.practicaH.jpa.entity.Course;
import org.certificatic.spring.data.practicaH.jpa.entity.Department;
import org.certificatic.spring.data.practicaH.jpa.entity.Person;
import org.certificatic.spring.data.practicaH.jpa.entity.Staff;
import org.certificatic.spring.data.practicaH.jpa.entity.Student;
import org.certificatic.spring.data.practicaH.jpa.repositories.CourseRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.DepartmentRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.StaffRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles({ "init-database" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = SpringDataJpaConfiguration.class)
public class SpringDataJpaQueryDemosTest {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StaffRepository staffRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	// Simple Property Expression Queries.
	@Test
	public void simpleQueryExamples() {

		log.info("simpleQueryExamples test starts =======================================================");

		System.out.println("\nFind students born at 1988-02-13");
		LocalDate date = LocalDate.of(1988, 02, 13);
		// busca los estudiantes con fecha de nacimiento "date"

		System.out.println("\nFind full time students");
		// busca los estudiantes de tiempo completo

		System.out.println("\nFind students with 'doe' as last name");
		// busca los estudiantes por "lastName"

		log.info("simpleQueryExamples test ends =======================================================");
	}

	// Advanced Property Expression Queries
	@Test
	public void intermediateQueryExamples() {

		log.info("intermediateQueryExamples test starts =======================================================");

		Student janeDoe = null; // busca el estudiante por "Attendee"
		System.out.println("Find students by name with Person Object \n" + janeDoe + "\n");

		Student janeDoeTraverse = null; // busca el estudiante por "attendeeFirstName" y "attendeeLastName" 
		System.out.println("Find students by name and traverse entities \n"
				+ janeDoeTraverse + "\n");

		System.out.println("Find Students Greather than 1987-07-22");
		LocalDate date = LocalDate.of(1987, 07, 22);
		// busca los estudiantes con fecha de nacimiento mayor a "date"

		System.out.println("\nFind Students under 1987-07-22");
		// busca los estudiantes con fecha de nacimiento menor a "date"

		System.out.println("\nFind Students with 'DOE' as last name, despite the case");
		// busca los estudiantes con "lastName" ignorando mayosculas y/o minuscolas

		System.out.println("\nFind Students with an 'i' in the last name");
		// busca los estudiantes con "lastName" Like 

		// busca el primer estudiante en orden alfabetico ascendente por "lastName"
		System.out.println(
				"\nFind first Student in alphabet \n" + null );

		// busca el estudiante mas joven
		System.out.println("\nFind yungest Student \n" + null);

		// busca el estudiante mas viejo
		System.out.println("\nFind oldest Student \n" + null);

		System.out.println("\nFind 3 yungest Students");
		// busca los tres estudiantes mas jovenes

		System.out.println("\nFind 3 oldest Students");
		// busca los tres estudiantes mas viejos

		log.info("intermediateQueryExamples test ends =======================================================");
	}

	// Complex Queries with @Query and JPQL
	@Test
	public void jpqlQueries() {

		log.info("jpqlQueries test starts =======================================================");

		// *******Method Simplification*******

		System.out.println("\nFind Courses where Jones is the department Chair with Property Expression");
		// busca el curso donde el "lastName" igual a "Jones" es el jefe de departamento (derived query)

		System.out.println("\nFind Courses where Jones is the department Chair with @Query");
		// busca el curso donde el "lastName" igual a "Jones" es el jefe de departamento (@Query JPQL)

		// *******Complex Queries********

		Optional<Course> english101Optional = null; // busca el curso "English 101" por nombre
		Course english101 = english101Optional.orElse(null);

		System.out.println("\nFind Courses where English 101 is a prerequisite");
		// busca los cursos donde el curso "English 101" es prerequisito

		// busca el curso "English 101" utilizando su vista "CourseView"
		System.out.println("\nCourseView for English 101 \n" + null);

		log.info("jpqlQueries test ends =======================================================");
	}

	// Queries that use Paging and Sorting
	@Test
	public void pagingAndSortingQueries() {

		log.info("pagingAndSortingQueries test starts =======================================================");

		System.out.println("\nFind all 3-credit courses");
		// busca los cursos con 3 creditos

		int total3CreditsCourse = 0; // cuenta los cursos con 3 creditos
		String[] th = { "st", "nd", "rd", "th" };

		for (int i = 0; i < Math.ceil(total3CreditsCourse / 4D); i++) {
			System.out.println("\nFind " + (i + 1) + th[(i < 3) ? i : 3] + " 3-credit courses of " + total3CreditsCourse
					+ ", sort by credit, then course name");
			
			
			Page<Course> courses = null; // busca la pagina "i" de 4 elementos por pagina de los cursos con 3 creditos
									     // ordena por "credits" y "name" de forma ascendente

			courses.forEach(System.out::println);
		}

		System.out.println("\nFind all staff members, sort alphabetically by last name");
		
		Sort sortByLastName = null; // define un objeto Sort que ordene ascendentemente por "lastName" y "firstName"
		
		// busca todos los Staff ordenados por el objeto Sort previamente definido

		Page<Staff> members = null; // busca la primer pagina de 5 elementos de los Staff 
									// utilizando el ordenamiento "sortByLastName" definido previamente
		System.out.println("\nTotal number of staff members=" + members.getTotalElements());
		System.out.println("Total number of 5-element-pages=" + members.getTotalPages());
		System.out.println("Find first 5 Staff members, sort alphabetically by last name");
		members.forEach(System.out::println);

		log.info("pagingAndSortingQueries test ends =======================================================");
	}

	@Before
	@After
	public void printBanner() {
		System.out.println("*************************************************************************************");
	}

}