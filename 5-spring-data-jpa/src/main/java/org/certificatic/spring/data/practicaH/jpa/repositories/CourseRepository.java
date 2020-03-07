package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.certificatic.spring.data.practicaH.jpa.entity.Course;
import org.certificatic.spring.data.practicaH.jpa.view.CourseView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// Extiende de CrudRepository
public interface CourseRepository extends CrudRepository<Course, Long> {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)

	Iterable<Course> findByInstructorMemberLastName(String lastName);

	// Course findByInstructorIdEquals(Long id);

	Course findDistinctByInstructorIdEquals(Long id);

	// property expressions o derived queries
	List<Course> findByDepartmentChairMemberLastName(String lastname);

	@Query("FROM Course c " + "WHERE c.department.chair.member.lastName = :lastname")
	List<Course> findCoursesByChairLastName(@Param("lastname") String lastname);

	Optional<Course> findByName(String name);

	@Query("SELECT c FROM Course c JOIN c.prerequisites p WHERE p.id = ?1")
	List<Course> findByPrerequisitesId(Long id);

	@Query("SELECT c FROM Course c JOIN c.prerequisites p WHERE p.name = ?1")
	List<Course> findByPrerequisitesName(String name);

	@Query("SELECT "
			+ "new org.certificatic.spring.data.practicaH.jpa.view."
			+ "CourseView(c.name, c.instructor.member.firstName, "
			+ "c.instructor.member.lastName, c.department.name) "
			+ "FROM Course c WHERE c.name = ?1")
	CourseView getCustomCourseViewByName(String name);

	List<Course> findByCredits(Integer credits);

	Page<Course> findByCredits(Integer credits, Pageable pageable);

}