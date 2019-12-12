package org.certificatic.spring.core.practica18.jsr330.bean.teams;

import java.util.List;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Team;

// Anotar como bean (singleton)
public class TeamX extends Team {

	@Override
	// Inyectar
	public void setEmployees(List<String> employees) {
		super.setEmployees(employees);
	}

	@Override
	// Inyectar
	public void setArchitect(Employee architect) {
		super.setArchitect(architect);
	}

	@Override
	// Inyectar
	public void setProgrammer(Employee programmer) {
		super.setProgrammer(programmer);
	}

	@Override
	// Inyectar
	public void setTester(Employee tester) {
		super.setTester(tester);
	}

}
