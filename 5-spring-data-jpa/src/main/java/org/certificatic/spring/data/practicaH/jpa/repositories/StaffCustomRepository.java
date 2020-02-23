package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.util.List;

import org.certificatic.spring.data.practicaH.jpa.entity.Staff;

public interface StaffCustomRepository {
	
	// Define un metodo customizado "searchStaffByFullname" para buscar Staff por lastname y firstname
	// la implementacion debe usar JPQL
	
	// Define un metodo customizado "searchNativeStaffByFullname" para buscar Staff por lastname y firstname
	// la implementacion debe usar SQL nativo
}