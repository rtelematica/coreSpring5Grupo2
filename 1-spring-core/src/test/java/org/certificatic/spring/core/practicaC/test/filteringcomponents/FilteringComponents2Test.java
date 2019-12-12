package org.certificatic.spring.core.practicaC.test.filteringcomponents;

import org.certificatic.spring.core.practicaC.filteringcomponents.bean.BabyBiker;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Bike;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Biker;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.Car;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository.BikeRepository;
import org.certificatic.spring.core.practicaC.filteringcomponents.bean.repository.CarRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = FilteringComponents2Test.location)
public class FilteringComponents2Test {

	public static final String location = "classpath:/spring/practicaC/filtering-components-application-context.xml";

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
