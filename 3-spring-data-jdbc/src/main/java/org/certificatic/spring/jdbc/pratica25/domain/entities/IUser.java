package org.certificatic.spring.jdbc.pratica25.domain.entities;

public interface IUser {
	Long getId();

	void setId(Long id);

	Customer getCustomer();

	void setCustomer(Customer customer);

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	boolean isNull();
}