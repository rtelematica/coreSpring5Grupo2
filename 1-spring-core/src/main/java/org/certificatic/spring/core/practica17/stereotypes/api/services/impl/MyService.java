package org.certificatic.spring.core.practica17.stereotypes.api.services.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IMyService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
// Anotar servicio, implementar Interface IMyService
@Service
@Scope("prototype")
public class MyService implements IMyService{

	// Inyectar con "resource" bean serviceClassName
	@Resource(name = "serviceClassName")
	private String name;
}
