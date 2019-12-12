package org.certificatic.spring.core.practicaC.test.filteringcomponents;

import org.certificatic.spring.core.practicaC.filteringcomponents.bean.BabyBiker;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Bike;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Biker;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Car;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository.BikeRepository;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository.CarRepository;
import org.certificatic.spring.core.practicaC.filteringcomponents.config.FilteringComponentsConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FilteringComponentsConfig.class)
public class FilteringComponents1Test {

	private Bike bike;

	private Car car;

	private Biker biker;

	private BabyBiker babyBiker;

	private BikeRepository bikeRepository;

	private CarRepository carRepository;

	@Before
	public void before() {
		Assert.assertNull(bikeRepository);
		Assert.assertNull(carRepository);

		Assert.assertNull(biker);
		Assert.assertNull(babyBiker);

		Assert.assertNotNull(car);
		Assert.assertNotNull(bike);
	}

	@Test
	public void filteringComponentsTest1() {

		log.info("filteringComponentsTest1 -------------------");

		log.info("bikeRepository: {}", bikeRepository);
		log.info("carRepository: {}", carRepository);

		log.info("---");

		log.info("biker: {}", biker);
		log.info("babyBiker: {}", babyBiker);

		log.info("---");

		log.info("car: {}", car);
		log.info("bike: {}", bike);

	}

}
