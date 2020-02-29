package org.certificatic.spring.jdbc.pratica25.dao.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.certificatic.spring.jdbc.pratica25.domain.entities.NullUser;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HandlerExceptionAspect {

	
	//@Around(value = "execution(* org.springframework.jdbc.core.JdbcOperations.queryForObject(..))")
	@Around(value = "execution(* org.springframework.jdbc.core.JdbcTemplate.queryForObject(..))")
	public Object handleExceptions(ProceedingJoinPoint pjp) throws Throwable {

		Object o = null;
		
		try {
			System.out.println("this is an aspect");
			o = pjp.proceed();

		} catch (EmptyResultDataAccessException ex) {
		}

		return o;
	}
	
	@Around(value = "execution(* org.certificatic.spring.jdbc.pratica25.dao.api.IUserDAO.findById(..))")
	public Object handleExceptions2(ProceedingJoinPoint pjp) throws Throwable {

		Object o = null;
		
		try {
			o = pjp.proceed();
			
			if(o == null)
				o = NullUser.getNullUser();

		} catch (EmptyResultDataAccessException ex) {
		}

		return o;
	}
}
