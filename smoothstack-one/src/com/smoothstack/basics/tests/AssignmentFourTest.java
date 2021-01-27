package com.smoothstack.basics.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.smoothstack.basics.weekone.AssignmentFour;

public class AssignmentFourTest {

	@Test
	public void testNoX() {
		List<String> listOne = Arrays.asList("ax", "bb", "cx");
		List<String> expectedListOne = Arrays.asList("a", "bb", "c");
		assertEquals(expectedListOne, AssignmentFour.noX(listOne));
		
		List<String> listTwo = Arrays.asList("xxax", "xbxbx", "xxcx");
		//expected value is the same as for the first list
		assertEquals(expectedListOne, AssignmentFour.noX(listTwo));
	}

}
