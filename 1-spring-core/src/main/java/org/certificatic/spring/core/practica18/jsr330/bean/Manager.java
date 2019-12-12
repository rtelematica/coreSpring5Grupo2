package org.certificatic.spring.core.practica18.jsr330.bean;

import lombok.Data;

@Data
//Anotar como bean (singleton)
public class Manager {

	// Inyectar
	private Employee employee;

	// Inyectar
	private Team team1;

	// Inyectar
	private Team team2;
}
