package org.certificatic.spring.jdbc.pratica25.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
public class NullUser extends User {

	private boolean isNull = true;

	private NullUser() {
	}

	public static IUser getNullUser() {
		return new NullUser();
	}

}
