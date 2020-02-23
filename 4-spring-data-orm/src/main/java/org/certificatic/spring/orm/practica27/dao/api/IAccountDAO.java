package org.certificatic.spring.orm.practica27.dao.api;

import java.util.List;

import org.certificatic.spring.orm.practica27.dao.IGenericDAO;
import org.certificatic.spring.orm.practica27.dao.hibernate.api.IHibernateExtraOperationsDAO;
import org.certificatic.spring.orm.practica27.domain.entities.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long>,
		IHibernateExtraOperationsDAO<Account, Long> {

	List<Account> findByCustomerId(Long id);
}
