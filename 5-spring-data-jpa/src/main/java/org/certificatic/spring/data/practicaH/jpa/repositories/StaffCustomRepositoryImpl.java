package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.certificatic.spring.data.practicaH.jpa.entity.Staff;

// Implementa StaffCustomRepository con los metodos customizados utilizando
// el objeto EntityManager a traves de ID mediante @PersistenceContext
public class StaffCustomRepositoryImpl  {

	// injecta
	private EntityManager entityManager;
	
	private static final String jpql = "SELECT s FROM Staff s WHERE s.member.firstName = :first AND s.member.lastName = :last";
	
	private static final String sql = "SELECT * FROM staff_member_tbl AS s WHERE s.student_first_name = :first AND s.student_last_name = :last";
	
	// @Override
	public List<Staff> searchStaffByFullname(String lastname, String firstname) {
		
		// Implementa
		
		return null;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	public List<Staff> searchNativeStaffByFullname(String lastname, String firstname) {
		
		// Implementa
		
		return null;
	}
}
