package org.certificatic.spring.core.practica3.jugador.api;

import org.certificatic.spring.core.practica3.liga.Partido;
import org.certificatic.spring.core.practica3.liga.Torneo;

public interface IJugador {

	String getNombre();

	Torneo getTorneo();

	Partido getPartido();

	void saludar();
}
