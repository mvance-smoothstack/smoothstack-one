package com.smoothstack.basics.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.smoothstack.basics.weekone.AssignmentTwo;

public class AssignmentTwoTest {

	@Test
	public void testRightDigits() {
		List<Integer> listOne = Arrays.asList(16, 8, 886, 8, 1);
		List<Integer> expectedListOne = Arrays.asList(6, 8, 6, 8, 1);
		assertEquals(expectedListOne, AssignmentTwo.rightDigits(listOne));
		
		List<Integer> listTwo = Arrays.asList(10, 0);
		List<Integer> expectedListTwo = Arrays.asList(0, 0);
		assertEquals(expectedListTwo, AssignmentTwo.rightDigits(listTwo));
		
	}

}
