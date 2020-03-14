package org.certificatic.spring.data.practicaI.mongodb.repositories;

import java.util.List;

import org.certificatic.spring.data.practicaI.mongodb.document.Department;

public interface DepartmentCustomRepository {

	// Metodos customizados
	List<Department> getDepartmentByChairId(Integer id);

	List<Department> getDepartmentByChairLastName(String lastName);
}
