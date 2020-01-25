package org.certificatic.spring.core.practica20.resources.bean;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Getter;

// Definir bean componente
@Component
// Implementar ResourceLoaderAware
public class BeanResourceLoaderAware implements ResourceLoaderAware {

	private @Getter ResourceLoader loader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}
}
