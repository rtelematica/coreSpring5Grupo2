package org.certificatic.spring.core.practicaE.propertyeditor.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.certificatic.spring.core.practicaE.propertyeditor.bean.CreditCard;
import org.certificatic.spring.core.practicaE.propertyeditor.bean.Customer;
import org.certificatic.spring.core.practicaE.propertyeditor.editor.CreditCardEditor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyEditorConfig {

	// Define el Bean CustomEditorConfigurer
	@Bean
	public static CustomEditorConfigurer customEditorConfigurer() {

		CustomEditorConfigurer cec = new CustomEditorConfigurer();

		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();

		// Implementar lo que falta
		customEditors.put(CreditCard.class, CreditCardEditor.class);

		cec.setCustomEditors(customEditors);
		
		return cec;
	}

	// Define el Bean Customer
	@Bean
	public Customer customerIvan(@Value("Ivan Garcia") String name, 
								 @Value("1111-2222-3333-4444") CreditCard creditCard) {
		return new Customer(name, creditCard);
	}
}
