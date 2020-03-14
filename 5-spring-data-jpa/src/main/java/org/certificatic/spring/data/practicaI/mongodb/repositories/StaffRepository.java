package org.certificatic.spring.data.practicaI.mongodb.repositories;

import java.util.List;

import org.certificatic.spring.data.practicaI.mongodb.document.Staff;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

//Extiende de PagingAndSortingRepository
public interface StaffRepository 
				extends PagingAndSortingRepository<Staff, Integer> {
	
	// Define los metodos conforme la practica lo requiera (guiado por instructor)

}