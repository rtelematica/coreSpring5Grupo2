package org.certificatic.spring.data.practicaH.jpa._config;

import java.time.LocalDate;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.certificatic.spring.data.practicaH.jpa.entity.Course;
import org.certificatic.spring.data.practicaH.jpa.entity.Department;
import org.certificatic.spring.data.practicaH.jpa.entity.Person;
import org.certificatic.spring.data.practicaH.jpa.entity.Staff;
import org.certificatic.spring.data.practicaH.jpa.entity.Student;
import org.certificatic.spring.data.practicaH.jpa.repositories.CourseRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.DepartmentRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.StaffRepository;
import org.certificatic.spring.data.practicaH.jpa.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Clase de configuración @Configuration
@Configuration
// Component Scan de paquete base Spring data practicaH JPA
@ComponentScan(basePackages = "org.certificatic.spring.data.practicaH.jpa")

// Habilitar repositorios Spring Data JPA

// Opcional habilitar manejo transaccional

public class SpringDataJpaConfiguration {
	
	// Definir Bean LocalContainerEntityManagerFactoryBean
	
	// Analiza las entidades definidas

	// Propiedades Hibernate
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		// properties.setProperty("hibernate.show_sql", "true");
		// properties.setProperty("hibernate.format_sql", "true");
		// properties.setProperty("hibernate.use_sql_comments", "true");
		
		// Dialecto para MySQL org.hibernate.dialect.MySQL5Dialect
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); 

		return properties;
	}

	// Opcional, definir Bean PlatformTransactionManager del tipo JpaTransactionManager

	// DAO Support, Translacion de excepciones
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	// Define Bean DataSource en memoria mediante EmbeddedDatabaseBuilder

	// Analiza
	@Bean
	@Profile("init-database")
	public ApplicationListener<ContextRefreshedEvent> startupBean(StudentRepository studentRepository,
			StaffRepository staffRepository, CourseRepository courseRepository,
			DepartmentRepository departmentRepository) {

		return new ApplicationListener<ContextRefreshedEvent>() {

			@SuppressWarnings("unused")
			@Override
			public void onApplicationEvent(ContextRefreshedEvent event) {

				// Students
				boolean fullTime = true;
				
				// almacena los estudiantes

				// Staff
				Staff deanJones = null; // almacena al StaffJohnJones
				Staff deanMartin = null; // almacena al StaffMatthewMartin
				Staff profBrown = null; // almacena al StaffJamesBrown
				Staff profMiller = null; // almacena al StaffJudyMiller
				Staff profDavis = null; // almacena al StaffJamesDavis
				Staff profMoore = null; // almacena al StaffAllisonMoore
				Staff profThomas = null; // almacena al StaffTomThomas
				Staff profGreen = null; // almacena al StaffGrahamGreen
				Staff profWhite = null; // almacena al StaffWhitneyWhite
				Staff profBlack = null; // almacena al StaffJackBlack
				Staff profKing = null; // almacena al StaffQueenKing

				// Departments
				Department humanities = null; // almacena al DepartmentHumanities con deanJones como jefe de depto
				Department naturalSciences = null; // almacena al DepartmentNaturalSciences como deanMartin como jefe de depto
				Department socialSciences = null; // almacena al DepartmentSocialSciencescomo deanJones como jefe de depto

				// Humanities Courses
				Course english101 = null; // almacena al CourseEnglish101 con profBlack como profesor del depto humanities
				Course english202 = null; // almacena al CourseEnglish202 con profBlack como profesor del depto humanities
				
				// agrega el curso english101 como prerequisito del curso english202
				
				Course english201 = null; // almacena al CourseEnglish201 con profBrown como profesor del depto humanities
				
				// agrega el curso english101 como prerequisito del curso english201
				

				// Natural Science Courses
				Course chemistry = null; // almacena al CourseChemistry con profDavis como profesor del depto  naturalSciences
				Course physics = null; // almacena al CoursePhysics con profDavis como profesor del depto naturalSciences
				
				// agrega el curso chemistry como prerequisito del curso physcics
				
				Course cProgramming = null; // almacena al CourseCProgramming con profMoore como profesor del depto naturalSciences
				Course jProgramming = null; // almacena al CourseJavaProgramming con profMoore como profesor del depto naturalSciences

				// Social Science Courses
				Course history101 = null; // almacena al CourseHistory101 con profMiller como profesor del depto socialSciences
				Course anthro = null; // almacena al CourseAnthropology con profKing como profesor del depto socialSciences
				
				// agrega el curso history101 como prerequisito del curso anthropology
				
				Course sociology = null; // almacena al CourseSociology con profKing como profesor del depto socialSciences
				
				// agrega el curso history101 como prerequisito del curso sociology
				
				Course psych = null; // almacena al CoursePsychology con profWhite como profesor del depto socialSciences
				
				// agrega el curso history101 y el curso english101 como prerequisitos del curso psychology

			}

			private Course createCoursePsychology(Staff profWhite, Department socialSciences) {
				return new Course("Psychology", 3, profWhite, socialSciences);
			}

			private Course createCourseSociology(Staff profKing, Department socialSciences) {
				return new Course("Sociology", 3, profKing, socialSciences);
			}

			private Course createCourseAnthropology(Staff profKing, Department socialSciences) {
				return new Course("Anthropology ", 3, profKing, socialSciences);
			}

			private Course createCourseHistory101(Staff profMiller, Department socialSciences) {
				return new Course("History 101", 3, profMiller, socialSciences);
			}

			private Course createCourseJavaProgramming(Staff profMoore, Department naturalSciences) {
				return new Course("Java Programming", 3, profMoore, naturalSciences);
			}

			private Course createCourseCProgramming(Staff profMoore, Department naturalSciences) {
				return new Course("C Programming", 3, profMoore, naturalSciences);
			}

			private Course createCoursePhysics(Staff profDavis, Department naturalSciences) {
				return new Course("Physics", 3, profDavis, naturalSciences);
			}

			private Course createCourseChemistry(Staff profDavis, Department naturalSciences) {
				return new Course("Chemistry", 3, profDavis, naturalSciences);
			}

			private Course createCourseEnglish201(Staff profBrown, Department humanities) {
				return new Course("English 201", 3, profBrown, humanities);
			}

			private Course createCourseEnglish202(Staff profBlack, Department humanities) {
				return new Course("English 202", 3, profBlack, humanities);
			}

			private Course createCourseEnglish101(Staff profBlack, Department humanities) {
				return new Course("English 101", 3, profBlack, humanities);
			}

			private Department createDepartmentSocialSciences(Staff deanJones) {
				return new Department("Social Sciences", deanJones);
			}

			private Department createDepartmentNaturalSciences(Staff deanMartin) {
				return new Department("Natural Sciences", deanMartin);
			}

			private Department createDepartmentHumanities(Staff deanJones) {
				return new Department("Humanities", deanJones);
			}

			private Staff createStaffQueenKing() {
				return new Staff(new Person("Queen", "King"));
			}

			private Staff createStaffJackBlack() {
				return new Staff(new Person("Jack", "Black"));
			}

			private Staff createStaffWhitneyWhite() {
				return new Staff(new Person("Whitney", "White"));
			}

			private Staff createStaffGrahamGreen() {
				return new Staff(new Person("Graham", "Green"));
			}

			private Staff createStaffTomThomas() {
				return new Staff(new Person("Tom", "Thomas"));
			}

			private Staff createStaffAllisonMoore() {
				return new Staff(new Person("Allison", "Moore"));
			}

			private Staff createStaffJamesDavis() {
				return new Staff(new Person("James", "Davis"));
			}

			private Staff createStaffJudyMiller() {
				return new Staff(new Person("Judy", "Miller"));
			}

			private Staff createStaffJamesBrown() {
				return new Staff(new Person("James", "Brown"));
			}

			private Staff createStaffMatthewMartin() {
				return new Staff(new Person("Matthew", "Martin"));
			}

			private Staff createStaffJohnJones() {
				return new Staff(new Person("John", "Jones"));
			}

			private Student createStudentAllyKim(boolean fullTime) {
				return new Student(new Person("ally", "kim"), !fullTime, LocalDate.of(1987, 07, 22));
			}

			private Student createStudentMikeSmith(boolean fullTime) {
				return new Student(new Person("mike", "smith"), fullTime, LocalDate.of(1987, 12, 06));
			}

			private Student createStudentJohnDoe(boolean fullTime) {
				return new Student(new Person("john", "doe"), fullTime, LocalDate.of(1987, 06, 23));
			}

			private Student createStudentKarlaJimenez(boolean fullTime) {
				return new Student(new Person("karla", "jimenez"), fullTime, LocalDate.of(1990, 01, 04));
			}

			private Student createStudentYulianaDoe(boolean fullTime) {
				return new Student(new Person("yuliana", "doe"), fullTime, LocalDate.of(1988, 02, 13));
			}

			private Student createStudentJaneDoe(boolean fullTime) {
				return new Student(new Person("jane", "doe"), fullTime, LocalDate.of(1988, 02, 13));
			}
		};
	}
}
