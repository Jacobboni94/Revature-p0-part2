package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.CarDAO;
import com.revature.dao.OfferDAO;
import com.revature.pojo.Car;
import com.revature.util.Input;
import com.revature.util.OfferUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestOfferUtil {
	
	@Mock
	Input input;
	
	@Mock
	CarDAO carDAO;
	
	@Mock
	OfferDAO offerDAO;
	
	OfferUtil offerUtil = new OfferUtil();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMakeOffer() {
		String username = "Jacob";
		offerUtil.setCarDAO(carDAO);
		offerUtil.setInput(input);
		offerUtil.setOfferDAO(offerDAO);
		Car car = new Car("abcdefghijflmnopq", "Jacob", 22000);

		when(input.getVin()).thenReturn("abcdefghijklmnopq");
		when(carDAO.getCarByVin("abcdefghijklmnopq")).thenReturn(car);
		when(input.getPrice()).thenReturn(21000.0);
		
		assertTrue(offerUtil.makeOffer(username));
	}

	@Test
	public void testRejectOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testAcceptOffer() {
		fail("Not yet implemented");
	}

}
