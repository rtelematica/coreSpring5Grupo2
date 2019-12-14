package org.certificatic.practica1.interfaces.livingbeing.test;

import org.certificatic.practica1.interfaces.livingbeing.api.IBugEater;
import org.certificatic.practica1.interfaces.livingbeing.api.ILivingBeing;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Aardvark;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Animal;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Plant;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.VenusFlyTrap;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingBeingTest {

	@Test
	public void livingBeingTest() {
		log.info("livingBeingTest -------------------");

		// Implementar
		ILivingBeing lb1 = new Aardvark();
		ILivingBeing lb2 = new VenusFlyTrap();

		log.info("livingBeing 1: {}", lb1);
		log.info("livingBeing 2: {}", lb2);

		lb1.lifeCycle();

		Assert.assertThat(Aardvark.class.getSimpleName(), 
						CoreMatchers.is(lb1.getClass().getSimpleName()));
		Assert.assertTrue(lb1 instanceof Aardvark);
		Assert.assertTrue(lb1 instanceof Animal);
		Assert.assertTrue(lb1 instanceof IBugEater);

		((IBugEater) lb1).eatBug();

		System.out.println();

		lb2.lifeCycle();

		Assert.assertThat(VenusFlyTrap.class.getSimpleName(), 
						CoreMatchers.is(lb2.getClass().getSimpleName()));
		Assert.assertTrue(lb2 instanceof VenusFlyTrap);
		Assert.assertTrue(lb2 instanceof Plant);
		Assert.assertTrue(lb2 instanceof IBugEater);
		
		((IBugEater) lb2).eatBug();

	}

}
