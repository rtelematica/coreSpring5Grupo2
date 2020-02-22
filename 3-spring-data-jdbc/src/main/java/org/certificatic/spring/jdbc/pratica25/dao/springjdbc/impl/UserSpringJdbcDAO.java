package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.certificatic.spring.jdbc.pratica25.dao.api.IUserDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper.UserRowMapper;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.IUser;
import org.certificatic.spring.jdbc.pratica25.domain.entities.NullUser;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.SneakyThrows;

@Repository
@Profile({ "h2-in-memory", "h2-local", "mysql" })
public class UserSpringJdbcDAO extends GenericSpringJdbcDAO<IUser, Long> implements IUserDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER_TBL VALUES (null, ?, ?)";
	private static final String INSERT_USER = "INSERT INTO USER_TBL VALUES (null, ?, ?, ?)";

	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER_TBL SET NAME = ?, LAST_NAME = ? WHERE CUSTOMER_ID = ?";
	private static final String UPDATE_USER = "UPDATE USER_TBL SET USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";

	private static final String SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID = "SELECT * FROM CUSTOMER_TBL INNER JOIN USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID WHERE USER_ID = ?";
	private static final String SELECT_ALL_USER_CUSTOMER = "SELECT * FROM CUSTOMER_TBL INNER JOIN USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID";

	// MEJORA
	@SuppressWarnings("unused")
	private static final String SELECT_ALL_CUSTOMER = "SELECT CUSTOMER_ID as ID, NAME, LAST_NAME as LASTNAME FROM CUSTOMER_TBL";

	// MEJORA
	@SuppressWarnings("unused")
	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT USER_ID as ID, USERNAME, PASSWORD FROM USER_TBL WHERE FK_CUSTOMER_ID = ?";

	private static final String DELETE_ACCOUNT_WHERE_CUSTOMER_ID = "DELETE FROM ACCOUNT_TBL WHERE FK_CUSTOMER_ID = ?";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM USER_TBL WHERE USER_ID = ?";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_ID = ?";

	// borrar
	// private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(IUser user) {

		// OJO REVISAR MODELO, IMPLEMENTAR LOGICA EAGER Y LAZY.

		// Implementar INSERT CUSTOMER obteniendo KeyHolder
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				// Implementar
				PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER,
						new String[] { "CUSTOMER_ID", "NAME", "LAST_NAME" });
				
				ps.setString(1, user.getCustomer().getName());
				ps.setString(2, user.getCustomer().getLastName());
				
				return ps;
			}
		}, keyHolder);
		
		user.getCustomer().setId(keyHolder.getKey().longValue());

		// Implementar INSERT USER recuperando fk_customer_id
		keyHolder = new GeneratedKeyHolder();
		
		String INSERT_USER = "INSERT INTO USER_TBL VALUES (null, ?, ?, ?)";

		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				// Implementar
				PreparedStatement ps = connection.prepareStatement(INSERT_USER,
						new String[] { "USER_ID", "FK_CUSTOMER_ID", "USERNAME", "PASSWORD" });
				
				ps.setLong(1, user.getCustomer().getId());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getPassword());
				return ps;
			}
		}, keyHolder);
		
		user.setId(keyHolder.getKey().longValue());

	}

	@Override
	public void update(IUser user) {

		// Implementar UPDATE CUSTOMER
		
		// Implementado mediante sql y parametros vararg
		// this.jdbcTemplate.update(UPDATE_CUSTOMER, user.getCustomer().getName(),
		//		user.getCustomer().getLastName(), user.getCustomer().getId());

		// Implementado mediante sql y setteo de parametros mediante
		// PreparedStatementSetter
		this.jdbcTemplate.update(UPDATE_CUSTOMER, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// Implementar
				ps.setString(1, user.getCustomer().getName());
				ps.setString(2, user.getCustomer().getLastName());
				ps.setLong(3, user.getCustomer().getId());
			}
		});

		// Implementar UPDATE USER

		// Implementado mediante sql y parametros vararg
		this.jdbcTemplate.update(UPDATE_USER, 
				user.getUsername(), user.getPassword(), user.getId());
	}

	@Override
	@SneakyThrows
	public IUser findById(Long id) {

		// OJO REVISAR MODELO, IMPLEMENTAR LOGICA EAGER Y LAZY.

		IUser u = null;

		// Implementar SELECT USER BY ID
		// FIND COMPLETE USER (WITH CUSTOMER) BY ID

		try {
			u = this.jdbcTemplate.queryForObject(SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					Customer customer = new Customer();

					user.setCustomer(customer);
					user.getCustomer().setUser(user);

					user.setId(rs.getLong("USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));

					customer.setId(rs.getLong("CUSTOMER_ID"));
					customer.setName(rs.getString("NAME"));
					customer.setLastName(rs.getString("LAST_NAME"));

					return user;
				}

			}, id);

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return NullUser.getNullUser();
		}

		return u;
	}

	@Override
	public IUser delete(Long id) {
		IUser user = this.findById(id);
		return this.delete(user);
	}

	@Override
	public IUser delete(IUser user) {
		if (user == null)
			return user;

		// DELETE COMPLETE RELATIONS OF USER WITH ALL TABLES

		// Pasar parametros a update
		this.jdbcTemplate.update(DELETE_ACCOUNT_WHERE_CUSTOMER_ID, new Object[] { user.getCustomer().getId() });

		// Pasar parametros a update
		this.jdbcTemplate.update(DELETE_USER_WHERE_USER_ID, user.getId());

		// Pasar parametros a update
		this.jdbcTemplate.update(DELETE_CUSTOMER_WHERE_CUSTOMER_ID, user.getCustomer().getId());

		return user;
	}

	@Override
	public List<IUser> findAll() {

		List<IUser> userList = null;

		// FIND COMPLETE ALL USER (WITH CUSTOMER)
		// Implementar mediante ResultSetExtractor

		userList = this.jdbcTemplate.query(SELECT_ALL_USER_CUSTOMER, new ResultSetExtractor<List<IUser>>() {
			
			private UserRowMapper rowMapper = new UserRowMapper();

			@Override
			public List<IUser> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<IUser> lista = new ArrayList<>();

				int i = 0;
				while (rs.next()) {
					lista.add(rowMapper.mapRow(rs, i++));
				}

				return lista;
			}

		});

		return userList;
	}

}
