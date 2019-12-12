package org.certificatic.spring.core.practicaA.lifecycle.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
// Implementar SmartLifecycle
public class Automovil {

	private String engine;
	private String model;
	private boolean isRunning;

	public void run() {
		log.info("Automovil model: {} run() ...", model);
	}

}
