package org.certificatic.spring.jdbc.pratica25.dao.springjdbc;

import java.io.Serializable;

import org.certificatic.spring.jdbc.pratica25.dao.IGenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import lombok.Getter;

public abstract class GenericSpringJdbcDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	// Inyectar JdbcTemplate
	@Autowired
	protected @Getter JdbcOperations jdbcTemplate;

	// Inyectar NamedParameterJdbcTemplate
	@Autowired
	protected @Getter NamedParameterJdbcOperations namedJdbcTemplate;

}
