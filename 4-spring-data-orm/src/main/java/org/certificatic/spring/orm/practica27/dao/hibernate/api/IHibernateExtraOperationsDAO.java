package org.certificatic.spring.orm.practica27.dao.hibernate.api;

import java.io.Serializable;

public interface IHibernateExtraOperationsDAO<T, ID extends Serializable> {

	void detach(final T entity);
}
