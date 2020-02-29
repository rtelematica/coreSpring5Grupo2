package org.certificatic.spring.orm.practica27.dao.jpa.impl;

import java.util.List;

import org.certificatic.spring.orm.practica27.dao.api.IAccountDAO;
import org.certificatic.spring.orm.practica27.dao.jpa.GenericJpaDAO;
import org.certificatic.spring.orm.practica27.domain.entities.Account;
import org.springframework.stereotype.Repository;

// Habilitar bean Repository 
@Repository
public class AccountJpaDAO extends GenericJpaDAO<Account, Long> implements IAccountDAO {

	public AccountJpaDAO() {
		super(Account.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Account> findByCustomerId(Long id) {

		return (List<Account>) this.entityManager
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE customer = " + id)
				.getResultList();
	}

}
