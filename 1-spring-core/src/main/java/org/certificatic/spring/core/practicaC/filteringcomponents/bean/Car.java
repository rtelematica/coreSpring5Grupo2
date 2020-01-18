package org.certificatic.spring.core.practicaC.filteringcomponents.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
// Anotar como servicio
@Service
public class Car {

	// Inyectar
	@Value("Mini Cooper JCW")
	public String model;
}
