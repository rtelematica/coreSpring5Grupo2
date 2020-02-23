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
import org.springframework.data.domain.Sort;
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
		Sort sortByLastName = new Sort(Sort.Direction.ASC, "member.lastName", "member.firstName");
		staffRepository.findAll(sortByLastName).forEach(System.out::println);

		int total3StaffMembers = Long.valueOf(staffRepository.count()).intValue();
		String[] th = { "st", "nd", "rd", "th" };

		for (int i = 0; i < Math.ceil(total3StaffMembers / 3D); i++) {
			System.out.println("\nFind " + (i + 1) + th[(i < 3) ? i : 3] + " 3 Staff members of " + total3StaffMembers
					+ ", sort by alphabetically by last name using PageRequest");
			Page<Staff> staff = staffRepository.findAll(PageRequest.of(i, 3, sortByLastName));
			staff.forEach(System.out::println);
		}

		System.out.println("\nFind first 3 Staff members, sort alphabetically by last name using PageRequest");
		Page<Staff> members = staffRepository.findAll(PageRequest.of(0, 3, sortByLastName));
		members.forEach(System.out::println);

		// Property Expression
		System.out.println("\nFind all staff members with last name King");
		staffRepository.findByMemberLastName("King").forEach(System.out::println);

		// @Query with JSON query string
		// "{ 'member.firstName' : ?0 }"
		System.out.println("\nFind all staff members with first name John");
		staffRepository.findByFirstName("John").forEach(System.out::println);

		// ***************Department query methods***************

		// Sorting example, MongoRepository extends PagingAndSortingRepository
		System.out.println("\nFind all Departments, sort alphabetically by name Descending");
		departmentRepository.findAll(new Sort(Sort.Direction.DESC, "name")).forEach(System.out::println);

		// Property Expression
		System.out.println("\nFind Department with the exact name 'Humanities' \n"
				+ departmentRepository.findByName("Humanities"));

		// @Query with JSON query string that accepts regular expression as a parameter
		// { 'name' : { $regex: ?0 } }
		// Any department name that ends in sciences where 's' is case insensitive
		System.out.println("\nFind all Departments with name ending in Sciences");
		departmentRepository.findNameByPattern(".[Ss]ciences").forEach(System.out::println);

		try {
			// Invalid Method, will fail at runtime
			System.out.println("\nInvalid Method, cannot cross DBRef's in queries");
			departmentRepository.findByChairMemberLastName("Jones");

			Assert.fail("Should fail at this point");

		} catch (MappingException ex) {
			System.out.println("exception: " + ex.getMessage());
		}

		log.info("mongoQueryMethods test ends =======================================================");
	}

	@Before
	@After
	public void printBanner() {
		System.out.println("*************************************************************************************");
	}

}