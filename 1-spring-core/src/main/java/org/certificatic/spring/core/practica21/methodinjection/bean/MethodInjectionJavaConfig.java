package org.certificatic.spring.core.practica21.methodinjection.bean;

import javax.inject.Singleton;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;
import org.certificatic.spring.core.practica21.methodinjection.bean.api.impl.StringProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MethodInjectionJavaConfig {
	
	@Bean
	@Singleton
	public SingletonBean singletonBean(@Value("3") Integer it) {
		
		SingletonBean sb = new SingletonBean() {

			@Override
			public IProcessor getProcessor() {
				return stringProcessor();
			}
		};
		
		sb.setIterations(it);
		
		return sb;
	}
	
	@Bean
	@Scope("prototype")
	public IProcessor stringProcessor() {
		return new StringProcessor();
	}
}
