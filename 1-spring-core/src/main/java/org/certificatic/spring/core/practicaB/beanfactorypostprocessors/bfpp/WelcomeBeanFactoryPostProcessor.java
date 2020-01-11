package org.certificatic.spring.core.practicaB.beanfactorypostprocessors.bfpp;

import java.util.Calendar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

// Implementar BeanFactoryPostProcessor
public class WelcomeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public static final String GOOD_AFTERNOON = "Good afternoon";
	public static final String GOOD_MORNING = "Good morning";

	public static boolean nowIsAfternoon() {
		return Calendar.getInstance().get(Calendar.AM_PM) == Calendar.PM;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		BeanDefinition definition = beanFactory.getBeanDefinition("welcomeBean");
		
		if(nowIsAfternoon()) {
			definition.getPropertyValues().add("greetingsText", GOOD_AFTERNOON);
		} else {
			definition.getPropertyValues().add("greetingsText", GOOD_MORNING);
		}
		
	}

}
