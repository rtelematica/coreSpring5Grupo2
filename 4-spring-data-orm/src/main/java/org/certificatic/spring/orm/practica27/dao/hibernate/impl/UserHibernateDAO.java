package org.certificatic.spring.orm.practica27.dao.hibernate.impl;

import org.certificatic.spring.orm.practica27.dao.api.IUserDAO;
import org.certificatic.spring.orm.practica27.dao.hibernate.GenericHibernateDAO;
import org.certificatic.spring.orm.practica27.domain.entities.User;
import org.springframework.stereotype.Repository;

//Habilitar bean Repository 
@Repository
public class UserHibernateDAO extends GenericHibernateDAO<User, Long>
		implements IUserDAO {

	public UserHibernateDAO() {
		super(User.class);
	}

}
