package org.certificatic.spring.core.practica10.beanpostprocessors.bpp;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.certificatic.spring.core.practica10.beanpostprocessors.bean.WorkerProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BeanPostProcessor2 implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("[Bean Post Process After Initialization " + this.getOrder() + "]");
		
		if(bean instanceof Worker) {
			Worker w = (Worker)bean;
			
			System.out.println("[BPP] proxying worker ...");
			
			WorkerProxy wp = new WorkerProxy(w);
			
			System.out.println("[BPP] worker proxied");
			
			bean = wp;
		}
		
		return bean;
	}

	@Override
	public int getOrder() {
		return 2;
	}

}