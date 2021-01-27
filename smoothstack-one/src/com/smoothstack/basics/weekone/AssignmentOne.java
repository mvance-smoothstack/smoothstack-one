/**
 * 
 */
package com.smoothstack.basics.weekone;

/**
 * @author max
 *
 */
public class AssignmentOne {

	public static String handleInput(String input) {	//input of something like "1 10"; first number is the function to run, second is input
		String[] splitInputs = input.split(" ");
		int value = Integer.parseInt(splitInputs[1]);
		String returnString = "";
		
		switch (splitInputs[0]) {
		case "1":
			returnString = checkParity().output(value);
			break;
		case "2":
			//is prime
			break;
		case "3":
			//palindrome
			break;
		default:
			//shouldn't get here
			returnString = "Bad input for the operation type, or another error happened.";
		}
		return returnString;
	}
	
	
	public static PerformOperation checkParity() {
		return (value) -> {
			if (value % 2 == 0) {
				return "EVEN";
			} else {
				return "ODD";
			}
		};
	}
	
	public static PerformOperation isPrime() {
		return (value) -> {
			//TODO: Pull in BigInteger and use that to check if it's prime? This isn't as easy as calling a method on Math.
			return "";
		};
	}


}
