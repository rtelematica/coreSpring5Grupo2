package org.certificatic.spring.aop.practica24.bank.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

//Define el Bean como Aspecto
@Aspect
@Component("serviceAccountLoggingAspect")
@Slf4j
public class ServiceAccountLoggingAspect implements Ordered {

	private @Getter int order = 2;

	@Autowired
	private IColorWriter colorWriter;

	// Define Advice Before que intercepte serviceLayer() y cache los argumentos
	@Before(value = "org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.serviceLayer() "
			+ "&& args(account,..)")
	public void beforeServiceAccountMethodExecutionAccount(JoinPoint jp, Account account) {
		
		Object[] args = jp.getArgs();
		
		if(args.length==2) {
			log.info("{}",
					colorWriter.getColoredMessage(Color.MAGENTA,
							"Inside accountService.updateAccountBalance(). Account: "
									+ account.getAccountNumber() + ", ammount: "
									+ ((Long)args[1])));
		} else {
			log.info("{}",
					colorWriter.getColoredMessage(Color.MAGENTA,
							"Inside accountService.updateAccountDescription(). Updating account ["
									+ account.getAccountNumber() + "] description to: "
									+ account.getAccountDescription()));
		}

	}

	// Define Advice Before que intercepte serviceLayer() y cache los argumentos
	@Before(value = "org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.serviceLayer() "
			+ "&& args(customerId)")
	public void beforeServiceAccountMethodExecutionLong(JoinPoint jp, Long customerId) {
		
		log.info("{}",
				colorWriter.getColoredMessage(Color.MAGENTA,
						"Inside accountService.findCustomerAccounts(). "
					  + "Finding accounts for customer: "+ customerId));

	}
}
