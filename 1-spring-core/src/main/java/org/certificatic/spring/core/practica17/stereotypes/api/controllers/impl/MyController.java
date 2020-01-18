package org.certificatic.spring.core.practica17.stereotypes.api.controllers.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IMyController;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
// Anotar controlador, implementar Interface IMyController
@Controller
public class MyController implements IMyController {
	
	// Inyectar con "resource" bean controllerClassName
	@Resource(name = "controllerClassName")
	private String name;
	
}
