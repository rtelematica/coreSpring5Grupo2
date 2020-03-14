package org.certificatic.spring.data.practicaI.mongodb.repositories;

import java.util.List;
import java.util.Optional;

import org.certificatic.spring.data.practicaI.mongodb.document.Department;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// Extiende de MongoRepository
public interface DepartmentRepository 
			extends MongoRepository<Department, Integer>, DepartmentCustomRepository {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)

	Optional<Department> findByName(String name);

	List<Department> findByNameEndingWithIgnoreCase(String name);

	@Query("{ 'name' : { $regex: ?0 } }")
	List<Department> findByPattern(String name);

	@Deprecated
	List<Department> findByChairMemberLastName(String lastName);

	List<Department> findByChairId(Integer id);
}
