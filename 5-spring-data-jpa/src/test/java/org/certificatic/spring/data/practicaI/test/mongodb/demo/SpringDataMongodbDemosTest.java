package org.certificatic.spring.data.practicaI.test.mongodb.demo;

import org.certificatic.spring.data.practicaI.mongodb._config.SpringDataMongodbConfiguration;
import org.certificatic.spring.data.practicaI.mongodb.document.Staff;
import org.certificatic.spring.data.practicaI.mongodb.repositories.DepartmentRepository;
import org.certificatic.spring.data.practicaI.mongodb.repositories.StaffRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mapping.MappingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles({ "init-database" })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataMongodbConfiguration.class)
public class SpringDataMongodbDemosTest {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@After
	public void afterClass() {
		mongoTemplate.getDb().drop();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void mongoQueryMethods() {

		log.info("mongoQueryMethods test starts =======================================================");

		// ***************Staff query methods***************

		// Paging and Sorting Queries
		System.out.println("\nFind all staff members, sort alphabetically by first name and last name");		
		Sort sortByLastName = new Sort(Direction.ASC, "member.lastName", "member.firstName"); // Define Sort por "member.lastName", "member.firstName" Ascendente
		
		// Consulta todo el Staff ordenado por Sort e imprime los resultados 
		staffRepository.findAll(sortByLastName)
						.forEach(s -> System.out.println(s));

		int total3StaffMembers = Long.valueOf(staffRepository.count()).intValue(); // Cuenta cuantos Staff existen en el repositorio
		String[] th = { "st", "nd", "rd", "th" };

		// Implementa paginacion
		for (int i = 0; i < Math.ceil(total3StaffMembers / 3D); i++) {
			
			System.out.println("\nFind " + (i + 1) + th[(i < 3) ? i : 3] + " 3 Staff members of " + total3StaffMembers
					+ ", sort by alphabetically by last name using PageRequest");
			
			Pageable pageable = PageRequest.of(i, 3, sortByLastName);
			Page<Staff> staff = staffRepository.findAll(pageable); // consulta todos los Staff de forma paginada (tamanio de pagina de 3 elementos) y ordenalos conforme a la variable Sort "sortByLastName" definida.
			
			staff.forEach(System.out::println);
		}

		System.out.println("\nFind first 3 Staff members, sort alphabetically by last name using PageRequest");
		Page<Staff> members = null; // busca la primera pagina de tamanio 3 de todos los Staff en el repositorio, utiliza la variable Sort "sortByLastName" para ordenarlos.
		members.forEach(System.out::println);

		// Property Expression
		System.out.println("\nFind all staff members with last name King");
		// busca los Staff con "member.lastName" igual a "King"

		// @Query with JSON query string
		// "{ 'member.firstName' : ?0 }"
		System.out.println("\nFind all staff members with first name John");
		// busca los Staff por "firstName" igual a "John", utiliza @Query para definir una consulta nativa MongoDB.

		// ***************Department query methods***************

		// Sorting example, MongoRepository extends PagingAndSortingRepository
		System.out.println("\nFind all Departments, sort alphabetically by name Descending");
		// busca todos los departamentos, ordenalos definiendo un Sort por "name" descendientemente.

		// Property Expression
		System.out.println("\nFind Department with the exact name 'Humanities' \n"
				+ null); // busca el departamento por "name" igual a "Humanities".

		// @Query with JSON query string that accepts regular expression as a parameter
		// { 'name' : { $regex: ?0 } }
		// Any department name that ends in sciences where 's' is case insensitive
		System.out.println("\nFind all Departments with name ending in Sciences");
		// busca todos los Department donde el "name" termine con "sciences" (case-insensitive), usa @Query methods
		
		// busca todos los Department donde el "name" termine con "sciences" (case-insensitive), usa derived queries
		

		try {
			// Invalid Method, will fail at runtime
			System.out.println("\nInvalid Method, cannot cross DBRef's in queries");
			// Intenta buscar los Department por Chair Member LastName igual a "Jones", utiliza derived queries.
			

			//Assert.fail("Should fail at this point");

		} catch (MappingException ex) {
			System.out.println("exception: " + ex.getMessage());
		}
		
		// Logra hacer la consulta de los Department por Chair Member LastName igual a "Jones", utiliza custom repositories.

		log.info("mongoQueryMethods test ends =======================================================");
	}

	@Before
	@After
	public void printBanner() {
		System.out.println("*************************************************************************************");
	}

}
