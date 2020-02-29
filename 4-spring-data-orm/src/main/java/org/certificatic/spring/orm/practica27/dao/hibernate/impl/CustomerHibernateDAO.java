package org.certificatic.spring.orm.practica27.dao.hibernate.impl;

import org.certificatic.spring.orm.practica27.dao.api.ICustomerDAO;
import org.certificatic.spring.orm.practica27.dao.hibernate.GenericHibernateDAO;
import org.certificatic.spring.orm.practica27.domain.entities.Customer;
import org.springframework.stereotype.Repository;

//Habilitar bean Repository 
@Repository
public class CustomerHibernateDAO extends GenericHibernateDAO<Customer, Long>
		implements ICustomerDAO {

	public CustomerHibernateDAO() {
		super(Customer.class);
	}

}
