package org.certificatic.spring.core.practica18.jsr330.bean.teams;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Team;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier.EmployeeType;

// Anotar como bean (singleton)
@Named("teamX")
@Singleton
public class TeamX extends Team {

	@Override
	// Inyectar
	@Resource(name = "teamXListStringBean")
	public void setEmployees(List<String> employees) {
		super.setEmployees(employees);
	}

	@Override
	// Inyectar
	@Inject
	@EmployeeQualifier(employeeType = EmployeeType.ARCHITECT)
	public void setArchitect(Employee architect) {
		super.setArchitect(architect);
	}

	@Override
	// Inyectar
	@Inject
	@EmployeeQualifier(employeeType = EmployeeType.PROGRAMMER)
	public void setProgrammer(Employee programmer) {
		super.setProgrammer(programmer);
	}

	@Override
	// Inyectar
	@Inject
	@EmployeeQualifier(employeeType = EmployeeType.TESTER)
	public void setTester(Employee tester) {
		super.setTester(tester);
	}

}
