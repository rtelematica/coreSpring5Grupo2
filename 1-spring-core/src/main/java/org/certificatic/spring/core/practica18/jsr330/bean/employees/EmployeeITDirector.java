package org.certificatic.spring.core.practica18.jsr330.bean.employees;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;

// Anotar como bean
public class EmployeeITDirector extends Employee {

	public EmployeeITDirector() {
		this.name = "Ivan Garcia";
		this.dni = "00-11-22-33";
	}
}
