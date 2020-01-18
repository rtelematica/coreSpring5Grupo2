package org.certificatic.spring.core.practica17.stereotypes.api.repositories.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IMyRepository;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
// Anotar repositorio, implementar Interface IMyRepository
@Repository
public class MyRepository implements IMyRepository{
	
	// Inyectar con "resource" bean repositoryClassName
	@Resource(name = "repositoryClassName")
	private String name;
	
}
