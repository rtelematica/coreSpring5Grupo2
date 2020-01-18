package org.certificatic.spring.core.practica17.stereotypes.api.components.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IMyComponent;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
// Anotar componente, implementar Interface IMyComponent
@Component
public class MyComponent implements IMyComponent {

	// Inyectar con "resource" bean componentClassName
	@Resource(name = "componentClassName")
	private String name;
}
