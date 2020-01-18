package org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
//Anotar como Repositorio
@Repository
public class CarRepository {

	// Inyectar
	@Value("jdbc://localhost:3306/car_db")
	public String repoURL;
}
