package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.DummyRepository;
import org.certificatic.spring.core.practica19.javaconfig.bean.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Habilitar Clase de configuracion
@Configuration
public class ServiceConfig {
	
	// Define Bean
	@Bean
	public DummyService dummyService(@Qualifier("dummyRepository") DummyRepository dr) {
		return new DummyService(dr);
	}

	// Define Bean
	@Bean
	public DummyService dummyService2(@Qualifier("dummyRepository2") DummyRepository dr) {
		return new DummyService(dr);
	}
}
