package org.certificatic.spring.core.practicaC.filteringcomponents.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
// Anotar como bean
public class BabyBiker extends Biker {

	// Inyectar
	public int age;
}
