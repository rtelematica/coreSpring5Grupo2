package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;

import org.certificatic.spring.jdbc.pratica25.dao.api.ICustomerDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.mapper.UserEntity;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object.CustomerMappingSqlQuery;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object.CustomerSqlUpdate;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object.UserSqlUpdate;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper.CustomerRowMapper;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class CustomerSpringJdbcDAO extends GenericSpringJdbcDAO<Customer, Long>
		implements ICustomerDAO, InitializingBean {

	private SimpleJdbcCall readCustomerProcedure;

	private SimpleJdbcInsert insertCustomer;
	private SimpleJdbcInsert insertUser;

	private CustomerMappingSqlQuery customerSqlQuery;
	private CustomerSqlUpdate customerSqlUpdate;
	private UserSqlUpdate userSqlUpdate;

	@Autowired
	private DataSource ds;

	private static final String SELECT_ALL_CUSTOMER_USER = "SELECT * FROM CUSTOMER_TBL, USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

	// Borrar
	// private NamedParameterJdbcTemplate namedJdbcTemplate;

	// Borrar
	// private @Getter JdbcTemplate jdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {

		this.readCustomerProcedure = new SimpleJdbcCall(ds)
				.withProcedureName("read_customer_user");

		this.insertCustomer = new SimpleJdbcInsert(ds).withTableName("CUSTOMER_TBL")
				.usingGeneratedKeyColumns("CUSTOMER_ID");

		this.insertUser = new SimpleJdbcInsert(ds).withTableName("USER_TBL")
				.usingGeneratedKeyColumns("USER_ID");

		this.customerSqlQuery = new CustomerMappingSqlQuery(ds);

		this.customerSqlUpdate = new CustomerSqlUpdate(ds);

		this.userSqlUpdate = new UserSqlUpdate(ds);
	}

	@Override
	public void insert(Customer customer) {

		// INSERT CUSTOMER
		KeyHolder keyHolder = this.insertCustomer
				.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(customer));

		customer.setId(keyHolder.getKey().longValue());

		// INSERT USER
		UserEntity userEntity = UserEntity.map(customer.getUser());

		keyHolder = this.insertUser.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(userEntity));

		customer.getUser().setId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Customer entity) {

		// UPDATE CUSTOMER
		this.customerSqlUpdate.execute(entity.getId(), entity.getName(), entity.getLastName());

		// UPDATE USER
		this.userSqlUpdate.execute(entity.getUser().getId(), entity.getUser().getUsername(),
				entity.getUser().getPassword());
	}

	@Override
	public Customer findById(Long id) {

		return new Random().nextBoolean() ? findUsingMappingSqlQuery(id) : findUsingProcedure(id);
	}

	private Customer findUsingMappingSqlQuery(Long id) {
		return this.customerSqlQuery.findObject(id);
	}

	private Customer findUsingProcedure(Long id) {
		// FIND USER OF CUSTOMER BY CUSTOMER_ID
		SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("in_customerId", id);

		Map<String, Object> out = readCustomerProcedure.execute(parameterSource);

		if ((Integer) out.get("#update-count-1") == 0)
			return null;

		User u = new User();
		Customer c = new Customer();

		u.setId(new Long((Integer) out.get("out_user_id")));
		u.setUsername((String) out.get("out_username"));
		u.setPassword((String) out.get("out_password"));

		c.setId(new Long((Integer) out.get("out_customer_id")));
		c.setName((String) out.get("out_name"));
		c.setLastName((String) out.get("out_last_name"));
		c.setUser(u);
		c.getUser().setCustomer(c);

		return c;
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
		final String DELETE_ACCOUNT_TABLE = "DELETE FROM ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
		final String DELETE_USER_TABLE = "DELETE FROM USER_TBL WHERE USER_ID = :userId";
		final String DELETE_CUSTOMER_TABLE = "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("customerId", customer.getId());
		paramMap.put("userId", customer.getUser().getId());

		this.namedJdbcTemplate.update(DELETE_ACCOUNT_TABLE, paramMap);
		this.namedJdbcTemplate.update(DELETE_USER_TABLE, paramMap);
		this.namedJdbcTemplate.update(DELETE_CUSTOMER_TABLE, paramMap);

		return customer;
	}

	@Override
	public List<Customer> findAll() {

		final List<Customer> customerList = new ArrayList<>();

		// FIND COMPLETE ALL CUSTOMER (WITH USER)
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
