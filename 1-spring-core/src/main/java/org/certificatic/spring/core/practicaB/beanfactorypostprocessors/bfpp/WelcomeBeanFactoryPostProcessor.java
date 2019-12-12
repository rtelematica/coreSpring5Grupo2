package org.certificatic.spring.core.practicaB.beanfactorypostprocessors.bfpp;

import java.util.Calendar;

// Implementar BeanFactoryPostProcessor
public class WelcomeBeanFactoryPostProcessor {

	public static final String GOOD_AFTERNOON = "Good afternoon";
	public static final String GOOD_MORNING = "Good morning";

	public static boolean nowIsAfternoon() {
		return Calendar.getInstance().get(Calendar.AM_PM) == Calendar.PM;
	}

}
