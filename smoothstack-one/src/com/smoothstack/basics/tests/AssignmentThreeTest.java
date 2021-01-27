package com.smoothstack.basics.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.smoothstack.basics.weekone.AssignmentThree;

public class AssignmentThreeTest {

	@Test
	public void testDoubleInts() {
		List<Integer> listOne = Arrays.asList(1, 2, 3);
		List<Integer> expectedListOne = Arrays.asList(2, 4, 6);
		assertEquals(expectedListOne, AssignmentThree.doubleInts(listOne));
		
		List<Integer> listTwo = Arrays.asList(6, 8, 6, 8, -1);
		List<Integer> expectedListTwo = Arrays.asList(12, 16, 12, 16, -2);
		assertEquals(expectedListTwo, AssignmentThree.doubleInts(listTwo));
	}

}
