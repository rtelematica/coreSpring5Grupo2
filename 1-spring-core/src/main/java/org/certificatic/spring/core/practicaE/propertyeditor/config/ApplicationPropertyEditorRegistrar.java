package org.certificatic.spring.core.practicaE.propertyeditor.config;

import org.certificatic.spring.core.practicaE.propertyeditor.bean.CreditCard;
import org.certificatic.spring.core.practicaE.propertyeditor.editor.CreditCardEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

// Implementa PropertyEditorRegistrar 
public class ApplicationPropertyEditorRegistrar implements PropertyEditorRegistrar{

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(CreditCard.class, new CreditCardEditor());
	}

}