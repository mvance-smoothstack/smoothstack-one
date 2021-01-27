package com.smoothstack.basics.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.smoothstack.basics.four.Line;

public class LineTest {
	private Line zeroLine = new Line(0, 0, 0, 0);
	private Line flatLine = new Line(1, 0, 10, 0);
	private Line upperFlatLine = new Line(5, 3, 20, 3);
	private Line tinyBitNotFlatLine = new Line(1, 0, 10.000001, 0);
	private Line downRightLine = new Line(3, 5, 12, -4);
	final private double TEST_DELTA = 0.0001;
	
	@Test
	public void getSlope() {
		/*
		 * Inputs are expected value, actual value, delta (difference within which JUnit
		 * considers them equal since floating-point operations are not exact).
		 */
		assertEquals(0.0, flatLine.getSlope(), TEST_DELTA);
		assertEquals(-1.0, downRightLine.getSlope(), TEST_DELTA);
	}
	
	@Test
	public void getSlopeFail() {
		assertNotEquals(1.0, upperFlatLine.getSlope(), TEST_DELTA);
		//have to pass in the method like this, instead of calling the method as normal
		assertThrows(ArithmeticException.class, zeroLine::getSlope);
	}
	
	@Test
	public void getDistance() {
		assertEquals(9.0, flatLine.getDistance(), TEST_DELTA);
		assertEquals(0.0, zeroLine.getDistance(), TEST_DELTA);
	}
	
	@Test
	public void getDistanceFail() {
		assertNotEquals(1.0, downRightLine.getDistance(), TEST_DELTA);
	}
	
	@Test
	public void parallelTo() {
		assertTrue(flatLine.parallelTo(upperFlatLine));
		//this should return true since tinyBitNotFlatLine's slope is within the delta coded into Line.parallelTo()
		assertTrue(flatLine.parallelTo(tinyBitNotFlatLine));
	}
	
	@Test
	public void parallelToFail() {
		assertFalse(flatLine.parallelTo(downRightLine));
	}
}
