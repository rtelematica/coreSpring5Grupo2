package org.certificatic.spring.core.practica18.jsr330.bean.secretaries;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Secretary;

// Anotar como bean (singleton)
public class SecretaryAssistant extends Secretary {

	@Override
	// Inyectar
	public void setEmployee(Employee employee) {
		super.setEmployee(employee);
	}

}
