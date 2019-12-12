package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.Optional;

import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;

import lombok.Data;

@Data
// Anotar como bean
public class Corporation {

	// Inyectar
	private IDirector generalDirector;

	// Inyectar
	private IDirector itDirector;

	// Inyectar
	private Optional<Secretary> generalSecretary;

	// Inyectar
	private Secretary secretaryAssistant;

	// Inyectar
	private Manager manager;
}
