/**
 * 
 */
package com.smoothstack.basics.one;

import java.util.Random;
import java.util.Scanner;

/**
 * @author max
 *
 */
public class RandomGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int theNumber;
		Random randomGenerator = new Random();
		Scanner input = new Scanner(System.in);
		theNumber = randomGenerator.nextInt(99) + 1;	//the number the player is trying to guess
		int guess = 0;
		final int TRIES = 5;	//number of attempts the player gets
		
		for (int x = 0; x < TRIES; x++) {
			System.out.println("What is your guess? Input a number between 1-100.");
			guess = input.nextInt();
			if ((guess > (theNumber - 10) && guess < (theNumber + 10))) {		//if the guess was within 10 of the number, win
				System.out.println("You win!");
				break;
			} else {
				System.out.println("Sorry, that wasn't within 10 of the number.");
				if (x == (TRIES - 1)) {
					System.out.println("That was your last try.");
				}
			}
		}
		System.out.print("The number was " + theNumber + ".");	//whether the player won or lost, tell the number
		
		input.close();		//and close the scanner at the end
	}

}
