package org.certificatic.spring.core.practica18.jsr330.bean.employees;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;

// Anotar como bean
public class EmployeeManager extends Employee {

	public EmployeeManager() {
		this.name = "Ilse Hernandez";
		this.dni = "11-44-77-55";
	}
}
