package org.certificatic.spring.aop.practica24.bank.service.account.api.impl;

import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.dao.account.api.IAccountDAO;
import org.certificatic.spring.aop.practica24.bank.service.account.api.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;

	@Override
	public void updateAccountBalance(Account account, Long amount) {
		accountDAO.updateBalance(account, amount);
	}

	@Override
	public List<Account> findCustomerAccounts(Long customerId) {
		return accountDAO.findByCustomerId(customerId);
	}

	@SneakyThrows
	@Override
	public void updateAccountDescription(Account account) {
		Thread.sleep(1500);
		accountDAO.updateDescription(account);
	}

}
