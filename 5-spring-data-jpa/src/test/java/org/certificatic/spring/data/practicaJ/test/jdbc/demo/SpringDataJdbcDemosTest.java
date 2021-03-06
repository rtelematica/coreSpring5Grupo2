package org.certificatic.spring.data.practicaJ.test.jdbc.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.certificatic.spring.data.practicaJ.jdbc._config.SpringDataJdbcConfiguration;
import org.certificatic.spring.data.practicaJ.jdbc.entity.Chair;
import org.certificatic.spring.data.practicaJ.jdbc.entity.Department;
import org.certificatic.spring.data.practicaJ.jdbc.repositories.DepartmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJdbcConfiguration.class)
public class SpringDataJdbcDemosTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void jdbcSimpleMethods() {

		log.info("jdbcSimpleMethods test starts =======================================================");

		// ***************create domain objects***************

		// Chairs
		Chair deanJones = new Chair("Dean Jones");
		Chair deanMartin = new Chair("Dean Martin");
		Chair deanCain = new Chair("Dean Cain");

		List<Department> departments = Arrays.asList(
				new Department("Humanities", deanJones),
				new Department("Natural Sciences", deanMartin),
				new Department("Social Sciences", deanJones),
				new Department("Engineering", deanCain));

		// ***************Insert Departments***************
		
		long insertedDepartments = departments.stream()
				.peek(d -> System.out.println("department: "+ d))
				.map(d -> departmentRepository.save(d))
				.peek(d -> System.out.println("inserted department: "+ d))
				.count(); // Inserta los Department, utiliza un Stream y cuenta cuantos fueron insertados.
				

		log.info("Inserted {} departments\n", insertedDepartments);

		System.out.println();
		// ***************Simple Queries***************

		log.info("SQL to Fetch all Departments");
		// busca todos los Department
		departmentRepository.findAll().forEach(System.out::println);

		System.out.println();

		log.info("SQL to find By Name Humanities");
		Optional<Department> optionalDepartment = departmentRepository
				.findByName("Humanities"); // busca Department por "name" igual a "Humanities".

		optionalDepartment.ifPresent(department -> {

			log.info("Lookup Humanities department done\n" + department);

			System.out.println();

			// Modify Department, change chair from Dean Jones to Dean Cain
			log.info("Change Humanities Chair to Dean Cain");
			department.setChair(deanCain);

			System.out.println();

			log.info("SQL to update Humanities department. Deparment id = " + department.getId());
			// actualiza el Departamento (update)
			departmentRepository.save(department);

			System.out.println();
			
			log.info("SQL to fetch Humanities department\n" +
					departmentRepository.findByName("Humanities").get()); // busca de nuevo el Department por "name" igual a "Humanities".
		});
		
		System.out.println();

		log.info("jdbcSimpleMethods test ends =======================================================");
	}

	@Before
	@After
	public void printBanner() {
		System.out.println("*************************************************************************************");
	}

}
