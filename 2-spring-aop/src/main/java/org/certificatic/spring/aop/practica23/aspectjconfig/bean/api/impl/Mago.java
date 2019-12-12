package org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.IAdivinador;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean
// Define Bean como Aspecto
public class Mago implements IAdivinador {

	// Inyecta Dependencia
	private IColorWriter colorWriter;

	// Define pointcut que intercepte metodo IVoluntario.pensarxxx y que cache
	// el argumento
	private void cuandoUnVoluntarioPiensaEnAlgo(String pensamiento) {
	}

	// Define pointcut que intercepte metodo IVoluntario.getPxxx y que cache el
	// argumento
	private void cuandoUnVoluntarioQuiereHAcerTrampa(boolean hacerTrampa) {
	}

	@Override
	// Define advice Before para interceptar el pensamiento "antes de que el
	// voluntario piense en algo"
	public void interceptarPensamiento(JoinPoint jp, String pensamiento) {
		print(colorWriter.getColoredMessage(Color.YELLOW,
				"[Mago] El voluntario se prepara para pensar en algo... [Pensara en: "
						+ pensamiento + "]"));
	}

	// Define advice Around para envolver la llamada al metodo getPensamiento.
	// El metodo evalua si el voluntairo hara trampa o no.
	public Object hacerMagia(ProceedingJoinPoint pjp, boolean hacerTrampa)
			throws Throwable {

		if (hacerTrampa)
			return "No me he bañado en 5 dias";

		Object o = pjp.proceed();
		return o;
	}

	private void print(String mensaje) {
		log.info("{}", mensaje);
	}

}
