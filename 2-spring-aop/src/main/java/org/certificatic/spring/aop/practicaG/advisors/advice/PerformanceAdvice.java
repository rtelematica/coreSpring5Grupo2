package org.certificatic.spring.aop.practicaG.advisors.advice;

import java.lang.reflect.Method;

import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementa Advice MethodBeforeAdvice y AfterReturningAdvice
public class PerformanceAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	private long startTime = 0;
	private long finishTime = 0;

	@Autowired
	private IColorWriter colorWriter;

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		startTime = System.currentTimeMillis();
		
		log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
				"Executing method " + method.getName() + 
				" on object " + target.getClass().getName()));
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		finishTime = System.currentTimeMillis();
		
		double totalDuration = finishTime - startTime;
		
		log.info("{}", colorWriter.getColoredMessage(Color.BLUE, 
				"Finished executing method " + method.getName()+ 
				" on object " + target.getClass().getName() + 
				" in " + (totalDuration / 1000) + " seconds."));

	}

}
