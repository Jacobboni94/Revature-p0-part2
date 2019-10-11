package com.revature.test;

import static org.junit.Assert.assertEquals;
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

import com.revature.dao.UserDAO;
import com.revature.pojo.User;
import com.revature.util.Authorization;
import com.revature.util.Input;

@RunWith(MockitoJUnitRunner.class)
public class TestAuthorization {
	
	@Mock
	Input input;
	
	@Mock
	UserDAO userDAO;
	
	Authorization authorization = new Authorization();

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
	public void testLogin() {
		User user = new User("Jacob", "password");
		user.setType("customer");
		
		authorization.setInput(input);
		authorization.setUserDAO(userDAO);
		
		when(input.getUsername()).thenReturn("Jacob");
		when(input.getPassword()).thenReturn("password");
		when(userDAO.getUserByUsername("Jacob")).thenReturn(user);
		assertEquals("customer", authorization.login());
	}

	@Test
	public void testRegister() {
		
		authorization.setInput(input);
		authorization.setUserDAO(userDAO);
		
		when(input.getNewUsername()).thenReturn("Jacob");
		when(input.getPassword()).thenReturn("password");
		assertTrue(authorization.register());
	}
}
