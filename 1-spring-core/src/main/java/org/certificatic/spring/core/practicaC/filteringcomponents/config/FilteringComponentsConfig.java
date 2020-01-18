package org.certificatic.spring.core.practicaC.filteringcomponents.config;

import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Biker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

// Anotar como clase de Configuracion
@Configuration

// Component scan base = "org.certificatic.spring.core.practicaC",
@ComponentScan(basePackages = "org.certificatic.spring.core.practicaC",

	// excluir anotaciones @Repository y
	// excluir tipos asignables a Biker.class
	excludeFilters = {
		@Filter(classes = Repository.class), 
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Biker.class)
	})
public class FilteringComponentsConfig {

}
