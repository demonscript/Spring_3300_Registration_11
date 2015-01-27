package com.demon.registeration.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.demon.registeration.entity.User;

public class ActionText {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		//ua.setUsername("wwwww");
		//ua.setPassword("12345");
		String ret = ua.execute();
		assertEquals("success", ret);
	//	fail("Not yet implemented");
	}

}
