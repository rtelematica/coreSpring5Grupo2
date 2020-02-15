package org.certificatic.spring.aop.practica24.bank.aop.logging;

import java.math.BigDecimal;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

// Define el Bean como Aspecto
@Aspect
@Component("daoAccountLoggingAspect")
@Slf4j
public class DAOAccountLoggingAspect implements Ordered {

	private @Getter int order = 3;

	@Autowired
	private IColorWriter colorWriter;

	// Define Pointcut que intercepte dataAccessLayer() y cache los argumentos
	@Pointcut("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.dataAccessLayer() "
			+ "&& args(xx,..)")
	public void beforeDAOAccountMethodExecutionAccountPointcut(Account xx) {
	}

	// Define Advice Before
	@Before("beforeDAOAccountMethodExecutionAccountPointcut(yy)")
	public void beforeDAOAccountMethodExecutionAccount(JoinPoint jp, Account yy) {

		Object[] args = jp.getArgs();

		if (args.length == 2) {
			log.info("{}", colorWriter.getColoredMessage(Color.RED, "Inside accountDAO.updateBalance(). Account: "
					+ yy.getAccountNumber() + ", ammount: " + (Long) args[1]));
		} else {
			log.info("{}",
					colorWriter.getColoredMessage(Color.RED,
							"Inside accountDAO.updateAccountDescription(). Updating account [" + yy.getAccountNumber()
									+ "] description to: " + yy.getAccountDescription()));
		}
	}

	// Define Pointcut que intercepte dataAccessLayer() y cache los argumentos
	@Pointcut("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.dataAccessLayer() " + "&& args(aa)")
	public void beforeDAOAccountMethodExecutionLongPointcut(Long aa) {
	}

	// Define Advice Before
	@Before("beforeDAOAccountMethodExecutionLongPointcut(bb)")
	public void beforeDAOAccountMethodExecutionLong(Long bb) {

		log.info("{}", colorWriter.getColoredMessage(Color.RED,
				"Inside accountDAO.findByCustomerId(). " + "Finding accounts for customer: " + bb));
	}

	@AfterReturning(value = "org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.dataAccessLayer() "
			+ "&& args(aa)", returning = "listAcc")
	public void longMethod(JoinPoint jp, List<Account> listAcc, Long aa) {

		for (Account acc : listAcc) {
			acc.setBalance(acc.getBalance().add(new BigDecimal(1000)));
		}
	}

}
