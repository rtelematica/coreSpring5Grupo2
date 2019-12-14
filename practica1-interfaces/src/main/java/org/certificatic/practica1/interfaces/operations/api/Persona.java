package org.certificatic.practica1.interfaces.operations.api;

import lombok.ToString;

@ToString
public class Persona {

	private String nombre;
	private String sexo;

	public Persona() {
	}

	private Persona setName(String name) {
		this.nombre = name;
		return this;
	}

	private Persona setSexo(String sexo) {
		this.sexo = sexo;
		return this;
	}

	public static void main(String[] args) {

		Persona p = new Persona();
		p.setName("Ivan").setName("Paula").setSexo("MAsculino");
		System.out.println(p);
	}
}
