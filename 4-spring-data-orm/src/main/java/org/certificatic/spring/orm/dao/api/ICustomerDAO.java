package org.certificatic.spring.orm.dao.api;

import org.certificatic.spring.orm.dao.IGenericDAO;
import org.certificatic.spring.orm.dao.hibernate.api.IHibernateExtraOperationsDAO;
import org.certificatic.spring.orm.domain.entities.Customer;

public interface ICustomerDAO extends IGenericDAO<Customer, Long>,
		IHibernateExtraOperationsDAO<Customer, Long> {
}
