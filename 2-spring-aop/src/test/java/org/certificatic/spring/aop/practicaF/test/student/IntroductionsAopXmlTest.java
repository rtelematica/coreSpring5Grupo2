package org.certificatic.spring.aop.practicaF.test.student;

import org.certificatic.spring.aop.practicaF.introductions.bean.Student;
import org.certificatic.spring.aop.practicaF.introductions.bean.StudentAdditionalDetails;
import org.certificatic.spring.aop.practicaF.introductions.bean.api.IStudent;
import org.certificatic.spring.aop.practicaF.introductions.bean.api.IStudentAdditionalDetails;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/practicaF/introductions-application-context.xml")
public class IntroductionsAopXmlTest {

	@Autowired
	private IStudent student;

	@Autowired
	private IStudentAdditionalDetails studentAdditionalDetails;

	@Before
	public void setUp() {
		Assert.assertNotNull(student);
		Assert.assertNotNull(studentAdditionalDetails);
	}

	@Test
	public void introductionsAopXMLTest() {

		log.info("introductionsAopXMLTest -------------------");

		student.getInfo();

		log.info("---");

		((IStudent) studentAdditionalDetails).getInfo();
		studentAdditionalDetails.showAdditionalDetails();

		Assert.assertTrue(student instanceof IStudent);
		Assert.assertTrue(student instanceof Student);

		Assert.assertTrue(!(student instanceof IStudentAdditionalDetails));
		Assert.assertTrue(!(student instanceof StudentAdditionalDetails));

		Assert.assertTrue(studentAdditionalDetails instanceof IStudentAdditionalDetails);
		Assert.assertTrue(studentAdditionalDetails instanceof IStudent);

		Assert.assertTrue(!(studentAdditionalDetails instanceof StudentAdditionalDetails));
		Assert.assertTrue(!(studentAdditionalDetails instanceof Student));
	}

}
