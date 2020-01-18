package org.certificatic.spring.core.practica15.autowired.requiredFalse.qualifier.bean;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Airplane {

	// Inyeccion no requerida
	@Autowired(required=false)
	private @Setter(AccessLevel.NONE) String airplaneCode;
	
	@Autowired
	private @Setter(AccessLevel.NONE) Optional<String> capitanName;
	
	@Autowired
	@Nullable
	private @Setter(AccessLevel.NONE) Integer totalPassengerSeats;

	// Inyeccion requerida
	// Inyectar un Airline especifica
	@Autowired
	@Qualifier("airline1")
	private @Setter(AccessLevel.NONE) Airline airline;

}
