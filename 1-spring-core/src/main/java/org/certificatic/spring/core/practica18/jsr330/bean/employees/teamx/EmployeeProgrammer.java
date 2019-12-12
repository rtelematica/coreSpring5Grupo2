package org.certificatic.spring.core.practica18.jsr330.bean.employees.teamx;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;

// Anotar como bean (singleton)
public class EmployeeProgrammer extends Employee {

	public EmployeeProgrammer() {
		this.name = "Team Leader Programmer";
		this.dni = "AA-BB-CC-DD";
	}
}
