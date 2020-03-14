package org.certificatic.spring.data.practicaI.mongodb.repositories;

import java.util.List;
import java.util.Optional;

import org.certificatic.spring.data.practicaI.mongodb.document.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// Extiende de MongoRepository
public interface DepartmentRepository 
						extends MongoRepository<Department, Integer> {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)

}
