package org.certificatic.spring.core.practicaE.test.propertyeditor;

import org.certificatic.spring.core.practicaE.propertyeditor.bean.CreditCard;
import org.certificatic.spring.core.practicaE.propertyeditor.bean.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = PropertyEditorRegistrarTest.location)
public class PropertyEditorRegistrarTest {

	public static final String location = "classpath:/spring/practicaE/property-editor-registrar-application-context.xml";

	@Value("1234-5698-7654-3210")
	private CreditCard creditCard;

	@Autowired
	private Customer customer;

	@Before
	public void setUp() {
		Assert.assertNotNull(creditCard);
		Assert.assertNotNull(customer);
	}

	@Test
	public void propertyEditorTest() {

		log.info("propertyEditorTest -------------------");

		log.info("credit card: {}", creditCard);

		log.info("customer: {}", customer);

		Assert.assertEquals(123456, creditCard.getBankIdNo(), 0);
		Assert.assertEquals(987654321, creditCard.getAccountNo(), 0);
		Assert.assertEquals(0, creditCard.getCheckCode(), 0);
		Assert.assertEquals("1234-5698-7654-3210", creditCard.getRawCardNumber());

		// 1111-2222-3333-4444
		Assert.assertEquals(111122, customer.getCreditCard().getBankIdNo(), 0);
		Assert.assertEquals(223333444, customer.getCreditCard().getAccountNo(), 0);
		Assert.assertEquals(4, customer.getCreditCard().getCheckCode(), 0);
		Assert.assertEquals("1111-2222-3333-4444", customer.getCreditCard().getRawCardNumber());
	}
}