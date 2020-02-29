package org.certificatic.spring.orm.practica27.dao.jpa.impl;

import org.certificatic.spring.orm.practica27.dao.api.ICustomerDAO;
import org.certificatic.spring.orm.practica27.dao.jpa.GenericJpaDAO;
import org.certificatic.spring.orm.practica27.domain.entities.Customer;
import org.springframework.stereotype.Repository;

//Habilitar bean Repository 
@Repository
public class CustomerJpaDAO extends GenericJpaDAO<Customer, Long> implements ICustomerDAO {

	public CustomerJpaDAO() {
		super(Customer.class);
	}

}
