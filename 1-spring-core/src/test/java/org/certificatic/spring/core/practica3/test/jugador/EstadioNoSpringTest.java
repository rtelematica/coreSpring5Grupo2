package org.certificatic.spring.core.practica3.test.jugador;

import org.certificatic.spring.core.practica3.jugador.JugadorFutbol;
import org.certificatic.spring.core.practica3.liga.Evento;
import org.certificatic.spring.core.practica3.liga.Partido;
import org.certificatic.spring.core.practica3.liga.Torneo;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EstadioNoSpringTest {

	@Test
	public void estadioNoSpringTest() {
		log.info("estadioNoSpringTest -------------------");

		// Implementar Test
		Evento evento = new Evento();
		evento.setNombre("Mundial Qatar 2022");
		
		Assert.assertNotNull(evento);
		Assert.assertNotNull(evento.getNombre());

		Torneo torneo = new Torneo("4tos de Final", evento);
		
		Partido partido = new Partido();
		partido.setNombre("Mexico vs Australia");

		Assert.assertNotNull(torneo);
		Assert.assertNotNull(torneo.getEvento());
		Assert.assertNotNull(torneo.getNombre());
		Assert.assertNotNull(partido);
		Assert.assertNotNull(partido.getNombre());

		JugadorFutbol jugador = new JugadorFutbol();

		jugador.setNombre("Chicharito");
		jugador.setTorneo(torneo);
		jugador.setPartido(partido);
		
		Assert.assertNotNull(jugador);
		Assert.assertNotNull(jugador.getTorneo());
		Assert.assertNotNull(jugador.getPartido());
		
		jugador.saludar();
		
		System.out.println(jugador.getPartido());
		System.out.println(jugador.getTorneo());
		System.out.println(jugador.getTorneo().getEvento());

	}

}
