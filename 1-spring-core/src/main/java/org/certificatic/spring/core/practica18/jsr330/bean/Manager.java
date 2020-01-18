package org.certificatic.spring.core.practica18.jsr330.bean;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.certificatic.spring.core.practica18.jsr330.qualifiers.ManagerEmployeeQualifier;

import lombok.Data;

@Data
//Anotar como bean (singleton)
@Named
@Singleton
public class Manager {

	// Inyectar
	@Inject
	@ManagerEmployeeQualifier
	private Employee employee;

	// Inyectar
	@Resource(name = "teamX")
	private Team team1;

	// Inyectar
	@Resource(name = "teamY")
	private Team team2;
}
