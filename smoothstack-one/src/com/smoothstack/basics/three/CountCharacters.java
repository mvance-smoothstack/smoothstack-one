/**
 * 
 */
package com.smoothstack.basics.three;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author max
 *
 */
public class CountCharacters {

	/**
	 * Search countme.txt for a character specified on the command line. Case-sensitive.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the character you want counted at the command line.");
			System.exit(0);
		}
		char find = args[0].charAt(0);	//get the first character of the first argument, ignore everything else
		int count = 0;					//how many times we found the character
		
		try {
			FileReader myFile = new FileReader("testdir/countme.txt");
			while (myFile.ready()) {			//while there are still characters to read...
				if (myFile.read() == find) {	//get the next character from the file...
					count++;					//and increment count if they match
				}
			}
			myFile.close();
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't find testdir/countme.txt.");
		} catch (IOException e) {
			System.err.println("Couldn't read testdir/countme.txt.");
		} 
		System.out.println("Found the character \"" + find + "\" this many times: " + count);
	}

}
