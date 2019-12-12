package org.certificatic.spring.core.practica18.jsr330.bean.employees.teamx;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;

// Anotar como bean (singleton)
public class EmployeeTester extends Employee {

	public EmployeeTester() {
		this.name = "Team Leader Tester";
		this.dni = "AA-BB-CC-DD";
	}
}
