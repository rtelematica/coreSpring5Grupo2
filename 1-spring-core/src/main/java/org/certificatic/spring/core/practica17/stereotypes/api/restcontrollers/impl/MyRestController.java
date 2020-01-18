package org.certificatic.spring.core.practica17.stereotypes.api.restcontrollers.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IMyRestController;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
// Anotar rest controlador, implementar Interface IMyRestController
@RestController
public class MyRestController implements IMyRestController {

	// Inyectar con "resource" bean restControllerClassName
	@Resource(name = "restControllerClassName")
	private String name;
}
