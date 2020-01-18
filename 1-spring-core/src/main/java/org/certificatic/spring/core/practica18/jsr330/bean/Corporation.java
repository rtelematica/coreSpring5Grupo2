package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantQualifier;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryGeneralQualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
// Anotar como bean
@Named("ACMECorporationBean")
public class Corporation {

	// Inyectar
	@Inject // No inyecta ni por nombre ni por tipo, por que hay dos tipos
	@Qualifier("generalDirectorBean") // No recomendado
	private IDirector generalDirector;

	// Inyectar
	@Inject // Inyecta por nombre
	private IDirector itDirector;

	// Inyectar
	@Inject
	@SecretaryGeneralQualifier
	private Optional<Secretary> generalSecretary; // Esta vacante la posicion
	
	@Inject
	@SecretaryGeneralQualifier
	@Nullable
	private Secretary generalSecretaryMirror; // Esta vacante la posicion

	// Inyectar
	@Inject
	@SecretaryAssistantQualifier
	private Secretary secretaryAssistant;

	// Inyectar
	@Inject
	private Manager manager;
}
