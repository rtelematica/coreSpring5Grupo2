package org.certificatic.spring.data.practicaH.jpa.repositories;

import org.certificatic.spring.data.practicaH.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

// Extiende de JpaRepository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
}