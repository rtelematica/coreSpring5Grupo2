package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl.h2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.certificatic.spring.jdbc.pratica25.dao.api.ICustomerDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper.CustomerRowMapper;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile({ "h2-in-memory", "h2-local" })
public class CustomerSpringJdbcDAO extends GenericSpringJdbcDAO<Customer, Long>
		implements ICustomerDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER_TBL VALUES (null, :name, :lastName)";
	private static final String INSERT_USER = "INSERT INTO USER_TBL VALUES (null, :fkCustomerId, :username, :password)";

	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER_TBL SET NAME = :name, LAST_NAME = :lastName WHERE CUSTOMER_ID = :customerId";
	private static final String UPDATE_USER = "UPDATE USER_TBL SET USERNAME = :username, PASSWORD = :password WHERE USER_ID = :userId";

	private static final String SELECT_CUSTOMER = "SELECT * FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT * FROM USER_TBL WHERE FK_CUSTOMER_ID = :customerId";

	private static final String SELECT_ALL_CUSTOMER_USER = "SELECT * FROM CUSTOMER_TBL, USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

	private static final String DELETE_ACCOUNT_TABLE_WHERE_CUSTOMER_ID = "DELETE FROM ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM USER_TBL WHERE USER_ID = :userId";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";

	// Borrar
	// private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public void insert(Customer customer) {

		// INSERT CUSTOMER
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource
		parameterSource.addValue("name", customer.getName());
		parameterSource.addValue("lastName", customer.getLastName());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		this.namedJdbcTemplate.update(INSERT_CUSTOMER, parameterSource, keyHolder);

		customer.setId(keyHolder.getKey().longValue());

		// INSERT USER
		parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource
		parameterSource.addValue("fkCustomerId", customer.getUser().getCustomer().getId());
		parameterSource.addValue("username", customer.getUser().getUsername());
		parameterSource.addValue("password", customer.getUser().getPassword());

		keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		this.namedJdbcTemplate.update(INSERT_USER, parameterSource, keyHolder);

		customer.getUser().setId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Customer customer) {

		// UPDATE CUSTOMER
		Map<String, Object> mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		mapParameters.put("name", customer.getName());
		mapParameters.put("lastName", customer.getLastName());
		mapParameters.put("customerId", customer.getId());
		
		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update
		this.namedJdbcTemplate.update(UPDATE_CUSTOMER, mapParameters);

		// UPDATE USER
		mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		mapParameters.put("username", customer.getUser().getUsername());
		mapParameters.put("password", customer.getUser().getPassword());
		mapParameters.put("userId", customer.getUser().getId());
		
		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update
		this.namedJdbcTemplate.update(UPDATE_USER, mapParameters);

	}

	@Override
	public Customer findById(Long id) {
		Customer customer = null;

		// FIND CUSTOMER BY ID
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", id);

		try {
			customer = this.namedJdbcTemplate.queryForObject(SELECT_CUSTOMER,
					parameterSource,
					(rs, n) ->{
						Customer cust = new Customer();

						cust.setId(rs.getLong("CUSTOMER_ID"));
						cust.setName(rs.getString("NAME"));
						cust.setLastName(rs.getString("LAST_NAME"));
						return cust;
					});

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		// FIND USER OF CUSTOMER BY CUSTOMER_ID
		parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", customer.getId());

		User user = this.namedJdbcTemplate.queryForObject(
				SELECT_USER_WHERE_CUSTOMER_ID, parameterSource,
				(ResultSet rs, int rowNum) -> {

					// Implementar User solo
					User us = new User();

					us.setId(rs.getLong("USER_ID"));
					us.setUsername(rs.getString("USERNAME"));
					us.setPassword(rs.getString("PASSWORD"));
					
					return us;
				});

		customer.setUser(user);
		user.setCustomer(customer);

		return customer;
	}

	@Override
	public Customer delete(Long id) {
		Customer customer = this.findById(id);
		return this.delete(customer);
	}

	@Override
	public Customer delete(Customer customer) {
		if (customer == null)
			return customer;

		// DELETE COMPLETE RELATIONS OF CUSTOMER WITH ALL TABLES
		Map<String, Object> mapParameters = new HashMap<>();
		mapParameters.put("customerId", customer.getId());
		mapParameters.put("userId", customer.getUser().getId());

		// Implementar DELETE's utilizando NamedParameterJdbcTemplate y
		// mapParameters
		this.namedJdbcTemplate.update(DELETE_ACCOUNT_TABLE_WHERE_CUSTOMER_ID, mapParameters);
		this.namedJdbcTemplate.update(DELETE_USER_WHERE_USER_ID, mapParameters);
		this.namedJdbcTemplate.update(DELETE_CUSTOMER_WHERE_CUSTOMER_ID, mapParameters);

		return customer;
	}

	@Override
	public List<Customer> findAll() {

		final List<Customer> customerList = new ArrayList<>();

		// FIND COMPLETE ALL CUSTOMER (WITH USER)
                                
		// Implementar query utilizando NamedParameterJdbcTemplate y
		// RowCallbackHandler
		this.namedJdbcTemplate.query(SELECT_ALL_CUSTOMER_USER, new RowCallbackHandler() {
			
			private CustomerRowMapper customerRowMapper = new CustomerRowMapper();
			
			private int i = 0;
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				customerList.add(customerRowMapper.mapRow(rs, i++));
			}
		});

		return customerList;
	}

}
