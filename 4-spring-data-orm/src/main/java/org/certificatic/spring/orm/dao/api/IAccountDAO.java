package org.certificatic.spring.orm.dao.api;

import java.util.List;

import org.certificatic.spring.orm.dao.IGenericDAO;
import org.certificatic.spring.orm.dao.hibernate.api.IHibernateExtraOperationsDAO;
import org.certificatic.spring.orm.domain.entities.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long>,
		IHibernateExtraOperationsDAO<Account, Long> {

	List<Account> findByCustomerId(Long id);
}
