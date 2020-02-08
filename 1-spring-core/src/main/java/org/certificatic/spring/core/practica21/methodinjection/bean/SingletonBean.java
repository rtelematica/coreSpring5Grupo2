package org.certificatic.spring.core.practica21.methodinjection.bean;

import javax.inject.Singleton;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define componente singleton
@Component
@Singleton
public abstract class SingletonBean {

	// Inyectar valor 3
	@Value("3")
	private @Setter Integer iterations;

	public String process(String data) {
		log.info("SingletonBean id [{}]: sending to process data ...",
				super.hashCode());

		IProcessor processor = getProcessor();
		
		return processor.processData(data, iterations);
	}

	@Lookup("stringProcessor")
	public abstract IProcessor getProcessor();

}
// Define la estructura para inyectar metodos en este bean