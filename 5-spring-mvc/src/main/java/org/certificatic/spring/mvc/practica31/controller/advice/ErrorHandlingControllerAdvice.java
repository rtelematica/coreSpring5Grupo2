package org.certificatic.spring.mvc.practica31.controller.advice;

import org.certificatic.spring.mvc.practica31.controller.PersonsController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Anotar Controller Advice, asignar tipos a PersonsController.class
@ControllerAdvice(assignableTypes = { PersonsController.class })
public class ErrorHandlingControllerAdvice {

	// Anotar ExceptionHandler
	@ExceptionHandler(IndexOutOfBoundsException.class)
	// Anotar Response status 404 NOT FOUND
	@ResponseStatus(HttpStatus.NOT_FOUND)
	// Anotar ResponseBody
	@ResponseBody
	public RestResponseError onException(IndexOutOfBoundsException re) {
		return new RestResponseError(
				HttpStatus.NOT_FOUND, 
				re.getMessage(), 
				re.getClass().getSimpleName());
	}

}
