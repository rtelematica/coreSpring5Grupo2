package org.certificatic.spring.core.practica20.resources.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
// Definir bean componente
@Component("rockBands")
public class FavouriteRockBands {

	// Inyectar valor ${favourite.rockband.first}
	@Value("${favourite.rockband.first:Metallica}")
	private String firstRockBand;

	// Inyectar valor ${favourite.rockband.second}
	@Value("${favourite.rockband.second:Thalia}")
	private String secondRockBand;

	// Inyectar valor "My favourites rockbands are: ${favourite.rockband.first}
	// and ${favourite.rockband.second}"
	@Value("My favourites rockbands are: ${favourite.rockband.first:perro}" + 
			" and ${favourite.rockband.second:gato}")
	private String toString;

	public String toString() {
		return toString;
	}
}
