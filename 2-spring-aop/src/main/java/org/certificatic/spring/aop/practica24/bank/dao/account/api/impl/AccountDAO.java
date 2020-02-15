package org.certificatic.spring.aop.practica24.bank.dao.account.api.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.dao.account.api.IAccountDAO;
import org.springframework.stereotype.Repository;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AccountDAO implements IAccountDAO {

	@Override
	public List<Account> findByCustomerId(Long customerId) {
		log.info("Finding Accounts ...");

		List<Account> result = new ArrayList<>();
		result.add(Account.builder().accountNumber("000001")
									.accountDescription("Account 1")
									.balance(new BigDecimal(1500))
									.build());
		return result;
	}

	@SneakyThrows
	@Override
	public void updateBalance(Account account, Long amount) {
		log.info("Updating Account Balance ...");
		Thread.sleep(2000);
	}

	@Override
	public void updateDescription(Account account) {
		log.info(
				"Inside accountDAO.updateDescription(). Updating account [{}] description to: {}",
				account.getAccountNumber(), account.getAccountDescription());

		log.info("Updating Account Description ...");

	}

}
