package org.certificatic.spring.core.practica4.movies.api.impl;

import org.certificatic.spring.core.practica4.movies.api.IMovieFinder;
import org.certificatic.spring.core.practica4.movies.model.Movie;

public class MovieFinderImpl implements IMovieFinder {

	@Override
	public Movie find(String titulo) {
		// return new Movie(titulo);
		return Movie.builder().titulo(titulo).build();
	}
}
