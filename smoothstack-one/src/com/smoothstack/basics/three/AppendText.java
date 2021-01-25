/**
 * 
 */
package com.smoothstack.basics.three;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * @author max
 *
 */
public class AppendText {

	/**
	 * Write the current date and time to testdir/appendtext.txt.
	 * @param args
	 */
	public static void main(String[] args) {
		File myFile = new File("testdir/appendtext.txt");
		Date now = new Date();
		try {
			FileWriter myFileWriter = new FileWriter(myFile, true);	//open the file in append mode
			myFileWriter.write("Appended text on " + now.toString() + "\n");
			myFileWriter.close();
		} catch (IOException e) {
			System.err.println("Couldn't find testdir/appendtext.txt.");
		}
	}

}
