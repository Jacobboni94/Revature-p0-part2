package com.revature.test;

import static org.junit.Assert.assertTrue;
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
import com.revature.util.CarUtil;
import com.revature.util.Input;

@RunWith(MockitoJUnitRunner.class)
public class TestCarUtil {
	
	@Mock
	CarDAO carDAO;
	
	@Mock
	Input input;
	
	CarUtil carUtil = new CarUtil();

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
	public void testAddCarToLot() {
		carUtil.setInput(input);
		carUtil.setCarDAO(carDAO);
		
		when(input.getVin()).thenReturn("abcdefghijklmnopq");
		when(input.getPrice()).thenReturn(34000.00);
		
		
		assertTrue(carUtil.addCarToLot());
	}

	@Test
	public void testRemoveCarFromLot() {
		carUtil.setInput(input);
		carUtil.setCarDAO(carDAO);
		
		when(input.getVin()).thenReturn("abcdefghijklmnopq");
		
		
		assertTrue(carUtil.removeCarFromLot());
	}

	@Test
	public void testViewMyCars() {
		String username = "Jacob";
		carUtil.setCarDAO(carDAO);
		carUtil.setInput(input);
		
		assertTrue(carUtil.viewMyCars(username));
	}

	@Test
	public void testViewCarsForSale() {
		carUtil.setCarDAO(carDAO);
		carUtil.setInput(input);
		assertTrue(carUtil.viewCarsForSale());
	}

}
