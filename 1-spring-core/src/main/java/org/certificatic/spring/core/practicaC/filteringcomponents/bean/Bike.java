package org.certificatic.spring.core.practicaC.filteringcomponents.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
// Anotar como bean
@Component
public class Bike {

	// Inyectar
	@Value("BMW nine t")
	public String model;
}
