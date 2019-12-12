package org.certificatic.spring.orm.dao.api;

import org.certificatic.spring.orm.dao.IGenericDAO;
import org.certificatic.spring.orm.dao.hibernate.api.IHibernateExtraOperationsDAO;
import org.certificatic.spring.orm.domain.entities.User;

public interface IUserDAO extends IGenericDAO<User, Long>,
		IHibernateExtraOperationsDAO<User, Long> {
}
