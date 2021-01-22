/**
 * 
 */
package com.smoothstack.basics.two;

import java.util.Random;

/**
 * @author max
 *
 */
public class TwoDArrayMax {

	/**
	 * Makes a 10x10 2D array containing random integers from 1-1000.
	 * @return the array with random integers
	 */
	public static int[][] makeArray() {
		int[][] theArray = new int[10][10];		//10x10 size is arbitrary
		Random randomGenerator = new Random();
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				theArray[x][y] = randomGenerator.nextInt(1000) + 1;
			}
		}
		return theArray;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] myArray = makeArray();
		int[] max = new int[3];	//contains the maximum value, the X position, and the Y position
		
		for (int x = 0; x < myArray.length; x++) {
			for (int y = 0; y < myArray[x].length; y++) {
				if (myArray[x][y] > max[0]) {
					max[0] = myArray[x][y];	//store the new maximum value
					max[1] = x;				//store the X and Y positions
					max[2] = y;
				}
			}
		}
		System.out.println("The maximum value was " + max[0] + ", found at position " + max[1] + ", " + max[2] + ".");
		//TODO: Consider formatting the entire array for display and printing it out.
	}

}
