package org.certificatic.spring.orm.practica27.dao.jpa.impl;

import org.certificatic.spring.orm.practica27.dao.api.IUserDAO;
import org.certificatic.spring.orm.practica27.dao.jpa.GenericJpaDAO;
import org.certificatic.spring.orm.practica27.domain.entities.User;
import org.springframework.stereotype.Repository;

//Habilitar bean Repository 
@Repository
public class UserJpaDAO extends GenericJpaDAO<User, Long> implements IUserDAO {

	public UserJpaDAO() {
		super(User.class);
	}

}
