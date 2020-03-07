package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.time.LocalDate;
import java.util.List;

import org.certificatic.spring.data.practicaH.jpa.entity.Person;
import org.certificatic.spring.data.practicaH.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Extiende de JpaRepository
public interface StudentRepository extends JpaRepository<Student, Long> {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)
	
}