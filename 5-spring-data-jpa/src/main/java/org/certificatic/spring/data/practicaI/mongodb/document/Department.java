package org.certificatic.spring.data.practicaI.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// Define como Documento
@NoArgsConstructor
public class Department {

	// Define como Id
	private Integer id;

	private String name;

	// Define DBRef
	private Staff chair;

	public Department(Integer id, String name, Staff chair) {
		this.id = id;
		this.name = name;
		this.chair = chair;
	}

}
