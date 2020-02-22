package org.certificatic.spring.jdbc.pratica25.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
public class User implements IUser {

	private Long id;

	private Customer customer;

	private String username;

	private String password;

	private boolean isNull = false;

}
