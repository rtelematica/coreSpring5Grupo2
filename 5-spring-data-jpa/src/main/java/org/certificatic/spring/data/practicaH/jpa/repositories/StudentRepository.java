package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.time.LocalDate;
import java.util.List;

import org.certificatic.spring.data.practicaH.jpa.entity.Person;
import org.certificatic.spring.data.practicaH.jpa.entity.Student;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// Extiende de JpaRepository
public interface StudentRepository extends JpaRepository<Student, Long> {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)
	
	List<Student> findDistinctAlumniByAttendeeLastName(String lastName);

	List<Student> findDistinctByAttendeeLastNameIgnoreCase(String lastName);

	List<Student> findByCoursesNameIn(List<String> courseNames);

	List<Student> findDistinctByCoursesNameIn(List<String> courseNames);

	List<Student> findByBirthday(LocalDate birthday);

	List<Student> findByFullTimeIs(boolean fulltime);

	List<Student> findByAttendeeLastName(String lastName);

	Student findByAttendee(Person attendee);

	Student findByAttendeeFirstNameAndAttendeeLastName(String string, String string2);

	List<Student> findByBirthdayGreaterThan(LocalDate birthday);

	List<Student> findByBirthdayLessThan(LocalDate birthday);

	Student findFirstByOrderByAttendeeLastNameDesc();

	List<Student> findByAttendeeLastNameIgnoreCase(String lastname);

	List<Student> findByAttendeeLastNameLike(String lastname);

	Student findTopByOrderByBirthdayDesc();

	Student findTopByOrderByBirthdayAsc();

	List<Student> findTop3ByOrderByBirthdayDesc();

	List<Student> findTop3ByOrderByBirthdayAsc();
	
}