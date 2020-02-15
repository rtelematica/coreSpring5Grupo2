package org.certificatic.spring.aop.practicaG.advisors.bean;

import org.certificatic.spring.aop.practicaG.advisors.annotation.MonitorPerformance;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessService {

	@SneakyThrows
	// Anotar @MonitorPerformance
	@MonitorPerformance
	public void execute() {
		log.info("Init execute method ...");
		Thread.sleep(2000);
		log.info("execute method ended.");
	}
}
