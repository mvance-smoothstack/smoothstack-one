package com.smoothstack.basics.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.smoothstack.basics.weekone.SampleSingleton;

public class SampleSingletonTest {
	SampleSingleton mySS = SampleSingleton.getInstance();

	@Test
	public void getInstance() {
		assertEquals(mySS, SampleSingleton.getInstance());	//should return the same object
	}

}
