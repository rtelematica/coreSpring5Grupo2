package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.api.IQuadraticEquationService;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.impl.QuadraticEquationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

// Habilitar Clase de configuracion
@Configuration
// Habilitar component scan
@ComponentScan("org.certificatic.spring.core.practica19.javaconfig")
// Agregar Import de clases de configuracion Repository y Service
@Import({ RepositoryConfig.class, ServiceConfig.class })
public class ApplicationConfig {

	// Definir bean
	@Bean
	public IQuadraticEquationService quadraticService() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Qualifier("quadraticEquationServiceBean2")
	public IQuadraticEquationService quadraticService2() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	@Bean
	@Scope("prototype")
	public IQuadraticEquationService quadraticService3() {
		return new QuadraticEquationServiceImpl();
	}

}
