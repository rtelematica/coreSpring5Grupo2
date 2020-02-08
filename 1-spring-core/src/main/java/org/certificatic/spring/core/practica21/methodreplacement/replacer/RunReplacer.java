package org.certificatic.spring.core.practica21.methodreplacement.replacer;

import java.lang.reflect.Method;

import org.certificatic.spring.core.practica21.methodreplacement.bean.SportCar;
import org.springframework.beans.factory.support.MethodReplacer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar MethodReplacer
public class RunReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		int mills = 200;

		SportCar car = (SportCar) obj;

		log.info("Sport car model: {} is running at: {}...", car.getModel(), mills);

		return mills;
	}

}
