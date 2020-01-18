package org.certificatic.spring.core.practica15.required.bean;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class Cameraman {
	private String name;
	private Integer age;
	private String dni;

	// Inyectar
	@Required
	public void setName(String name) {
		this.name = name;
	}

	// Inyectar
	@Required
	public void setDni(String dni) {
		this.dni = dni;
	}

}
