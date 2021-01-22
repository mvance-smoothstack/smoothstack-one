/**
 * 
 */
package com.smoothstack.basics.two;

import java.util.ArrayList;

/**
 * @author max
 *
 */
public class CmdLineAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double sum = 0.0f;		//using double for ease of conversion
		ArrayList<String> badArgs = new ArrayList<String>();
		
		for(int x = 0; x < args.length; x++) {
			try {
				//try to convert the argument into a number
				sum = sum + Double.valueOf(args[x]);
			} catch(NumberFormatException badArg) {
				//if it can't be converted, add it to a list
				badArgs.add(args[x]);
			}
		}
		System.out.println("The sum is: " + sum);
		if (badArgs.size() > 0) {
			//tell the user the list of bad arguments, if any
			System.out.print("The following command line arguments were discarded: " + badArgs.toString());	
		}
	}

}
