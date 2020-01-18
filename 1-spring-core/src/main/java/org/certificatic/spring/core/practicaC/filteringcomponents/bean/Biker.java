package org.certificatic.spring.core.practicaC.filteringcomponents.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
// Anotar como bean
@Service
public class Biker {

	// Inyectar
	@Value("Isabella")
	public String name;
}
