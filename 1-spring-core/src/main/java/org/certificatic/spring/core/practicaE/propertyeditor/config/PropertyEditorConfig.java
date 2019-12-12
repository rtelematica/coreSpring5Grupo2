package org.certificatic.spring.core.practicaE.propertyeditor.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.certificatic.spring.core.practicaE.propertyeditor.bean.Customer;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyEditorConfig {

	// Define el Bean CustomEditorConfigurer
	public static CustomEditorConfigurer customEditorConfigurer() {

		CustomEditorConfigurer cec = new CustomEditorConfigurer();

		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();

		// Implementar lo que falta

		return cec;
	}

	// Define el Bean Customer
	public Customer customerIvan() {
		return null;
	}
}
