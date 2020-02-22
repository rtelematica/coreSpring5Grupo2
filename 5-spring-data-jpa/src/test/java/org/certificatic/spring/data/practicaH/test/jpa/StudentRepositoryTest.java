package org.certificatic.spring.data.practicaH.test.jpa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = SpringDataJpaConfiguration.class)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private CourseRepository courseRepository;


	@Test
	public void simpleStudentCrudExample() {

		log.info("simpleStudentCrudExample test starts =======================================================");
		
		// Staff
		Staff deanJones = null; // almacena el Staff createStaffJohnJones
		Staff profBlack = null; // almacena el Staff createStaffJackBlack

		// Departments
		Department humanities = null; // almacena el Departamento createDepartmentHumanities con deanJones como jefe de depto

		Course english101 = null; // almacena el Curso createCourseEnglish101 con profBlack como profesor del depto humanities
		Course english202 = null; // almacena el Curso createCourseEnglish202 con profBlack como profesor del depto humanities

		boolean fullTime = true;

		// almacena janeDoe dos veces
		// almacena johnDoe
		// almacena mikeSmith
		// almacena allyKim

		System.out.println("\n*************Original Students*************");
		List<Student> students = null; // busca todos los Student
		
		Assert.assertEquals(5, students.size());
		
		students.forEach(System.out::println);
		
		// age up the students
		@SuppressWarnings("unused")
		List<Student> studentsAltered = null; // busca todos los Student y modificalos,
											  // sumales un anio a su edad y actualizalos en bd.
											  // opera todo en un Stream.

		System.out.println("\n*************Students a year older*************");
		List<Student> studentsYearOlder = null; // busca todos los Student
		
		Assert.assertEquals(5, studentsYearOlder.size());
		
		studentsYearOlder.forEach(System.out::println);

		System.out.println("\n*************Distinct doe lastname Students*************");

		List<Student> doeStudents = null; // busca los distintos Student por attendeeLastName

		doeStudents.forEach(System.out::println);

		System.out.println(
				"\n*************doe lastname Students enrolled in courses English 101 and English 202*************");

		// Al alumno jonhDoe enrolar los cursos english101 y english202. almacenar los cambios

		List<Student> doeStudentsEnrolled = null; // buscar los Student enrolados por nombre de los cursos (lista)

		doeStudentsEnrolled.forEach(System.out::println);

		System.out.println(
				"\n*************Distinct doe lastname Students enrolled in courses English 101 and English 202*************");

		List<Student> distinctDoeStudentsEnrolled = null; // buscar los Student (distintos) enrolados por nombre de los cursos (lista)

		distinctDoeStudentsEnrolled.forEach(System.out::println);
		
		// borra todos los Student
		
		System.out.println("\n*************Students removed*************");
		List<Student> deletedStudents = null; // busca todos los Student
		
		Assert.assertEquals(0, deletedStudents.size());
		
		deletedStudents.forEach(System.out::println);

		log.info("simpleStudentCrudExample test ends =======================================================");
	}

	private Student allyKim(boolean fullTime) {
		return new Student(new Person("ally", "kim"), !fullTime, LocalDate.of(1987, 07, 22));
	}

	private Student mikeSmith(boolean fullTime) {
		return new Student(new Person("mike", "smith"), fullTime, LocalDate.of(1987, 12, 06));
	}

	private Student johnDoe(boolean fullTime) {
		return new Student(new Person("john", "doe"), fullTime, LocalDate.of(1987, 06, 23));
	}

	private Student janeDoe(boolean fullTime) {
		return new Student(new Person("jane", "doe"), fullTime, LocalDate.of(1988, 02, 13));
	}

	private Staff createStaffJackBlack() {
		return new Staff(new Person("Jack", "Black"));
	}

	private Staff createStaffJohnJones() {
		return new Staff(new Person("John", "Jones"));
	}

	private Department createDepartmentHumanities(Staff deanJones) {
		return new Department("Humanities", deanJones);
	}

	private Course createCourseEnglish202(Staff profBlack, Department humanities) {
		return new Course("English 202", 3, profBlack, humanities);
	}

	private Course createCourseEnglish101(Staff profBlack, Department humanities) {
		return new Course("English 101", 3, profBlack, humanities);
	}

}