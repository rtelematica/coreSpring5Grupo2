package org.certificatic.spring.core.practicaA.lifecycle.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.SmartLifecycle;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
// Implementar SmartLifecycle
public class Automovil implements SmartLifecycle, BeanNameAware {

	private String engine;
	private String model;
	private @Setter(AccessLevel.NONE) boolean isReady;
	private String myName;
	
	public void run() {
		log.info("Automovil("+myName+") model: {} run() ...", model);
	}

	@Override
	public void start() {
		log.info("starting Automovil ...");
		isReady = true;
	}

	@Override
	public void stop() {
		log.info("stopping Automovil ...");
		isReady = false;
	}

	@Override
	public boolean isRunning() {
		return isReady;
	}

	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}

}
