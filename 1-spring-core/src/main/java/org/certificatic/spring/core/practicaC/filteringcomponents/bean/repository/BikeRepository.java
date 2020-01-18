package org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
// Anotar como Repositorio
@Repository
public class BikeRepository {

	// Inyectar
	@Value("jdbc://localhost:3306/bike_db")
	public String repoURL;
}
