package com.demon.registeration.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.demon.registeration.entity.User;
import com.demon.registeration.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExists() {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("33333");
		u.setPassword("12312312");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);
	}

	@Test
	public void testAdd() {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("33333");
		u.setPassword("12312312");
		boolean exists = um.exists(u);
		if(!exists) {
			um.add(u); 
			exists = um.exists(u);
		} else {
			exists = false;
		}
		Assert.assertEquals(true, exists);
	}

}
