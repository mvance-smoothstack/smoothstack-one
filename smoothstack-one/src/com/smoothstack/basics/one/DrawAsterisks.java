/**
 * 
 */
package com.smoothstack.basics.one;

/**
 * @author max
 *
 */
public class DrawAsterisks {

	private static final int ITERATIONS = 4;	//the number of asterisks to print each time
	
	/**
	 * Prints asterisks in ascending order from left
	 */
	private static void ascending() {
		String asterisks = "";
		for (int x = 0; x < ITERATIONS; x++) {
			asterisks = asterisks + "*";
			System.out.println(asterisks);
		}
		System.out.println(makeDots(ITERATIONS * 2 + 1));
	}
	
	/**
	 * Prints asterisks in descending order from left
	 */
	private static void descending() {
		String asterisks = "";
		String[] lines = new String[ITERATIONS + 1];
		for (int x = 0; x < ITERATIONS; x++) {		//build up the array in order...
			asterisks = asterisks + "*";
			lines[x] = asterisks;
		}
		System.out.println(makeDots(ITERATIONS * 2 + 2));
		for (int x = ITERATIONS - 1; x >= 0; x--) {	//then print each index in reverse order
			System.out.println(lines[x]);
		}
	}
	
	/**
	 * Prints asterisks in the center of each line, in ascending order
	 */
	private static void ascendingCenter() {
		String asterisks = "*";
		for (int x = 0; x < ITERATIONS; x++) {
			System.out.println(leftPad(asterisks, ITERATIONS + 1 - x));
			asterisks = "*" + asterisks + "*";
		}
		System.out.println(makeDots(ITERATIONS * 2 + 3));
	}
	
	/**
	 * Prints asterisks in the center of each line, in descending order
	 */
	private static void descendingCenter() {
		String asterisks = "*";
		String[] lines = new String[ITERATIONS];
		for (int x = 0; x < ITERATIONS; x++) {					//same as before, fill an array with the lines
			lines[x] = leftPad(asterisks, ITERATIONS + 1 - x);
			asterisks = "*" + asterisks + "*";
		}
		System.out.println(makeDots(ITERATIONS * 2 + 4));
		for (int x = ITERATIONS - 1; x >= 0; x--) {				//and print them in reverse order
			System.out.println(lines[x]);
		}
	}
	
	/**
	 * Utility method for adding a certain number of spaces on the left side of a string
	 * @param input
	 * @param padCount
	 * @return
	 */
	private static String leftPad(String input, int padCount) {
		for (int x = 0; x < padCount; x++) {
			input = " " + input;
		}
		return input;
	}
	/**
	 * Makes a string of dots of arbitrary length
	 * @param count
	 * @return
	 */
	private static String makeDots(int count) {
		String dots = "";
		for (int x = 0; x < count; x++) {
			dots = dots + ".";
		}
		return dots;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1)");
		ascending();
		System.out.println("\n2)");
		descending();
		System.out.println("\n3)");
		ascendingCenter();
		System.out.println("\n4)");
		descendingCenter();
	}

}
