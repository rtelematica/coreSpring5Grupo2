package org.certificatic.spring.aop.practicaG.advisors.advice;

import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementa Advice MethodBeforeAdvice y AfterReturningAdvice
public class PerformanceAdvice {

	private long startTime = 0;
	private long finishTime = 0;

	@Autowired
	private IColorWriter colorWriter;

}
