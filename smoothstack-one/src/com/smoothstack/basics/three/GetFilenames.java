/**
 * 
 */
package com.smoothstack.basics.three;

import java.io.File;
import java.util.ArrayList;

/**
 * @author max
 *
 */
public class GetFilenames {

	/**
	 * Recursively searches a directory for all files and empty directories within.
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<File> allFiles = new ArrayList<File>();
		ArrayList<File> allDirs = new ArrayList<File>();
		//TODO: Consider taking the path to a directory at the command line instead of hardcoding testdir here.
		File root = new File("testdir");
		allDirs.add(root);						//put the starting directory on the allDirs list
		
		while (allDirs.size() != 0) {			//while we still have directories to look in
			File currentDir = allDirs.get(0);	//get the next directory to look in...
			allDirs.remove(0);					//and pop it off the list
			if (currentDir.list().length == 0) {//if the current directory is empty...
				allFiles.add(currentDir);		//then add it to allFiles to be displayed later
			} else {							//otherwise iterate through it
				ArrayList<File> foundDirs = getDirs(currentDir);
				ArrayList<File> foundFiles = getFiles(currentDir);
				allDirs.addAll(foundDirs);		//put dirs within to be searched on another pass of this while loop...
				allFiles.addAll(foundFiles);	//and files within to be displayed later
			}
		}										//now display all found files and empty dirs
		for (int x = 0; x < allFiles.size(); x++) {
			System.out.println(allFiles.get(x));
		}
		
	}
	
	
	/**
	 * Given a File that represents a directory, return files from within it.
	 * @param inputFile
	 * @return
	 */
	private static ArrayList<File> getFiles(File inputFile){
		ArrayList<File> foundFiles = new ArrayList<File>();
		File[] files = inputFile.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (files[x].isFile()) {		//if the file we're checking is a file (not a directory)
				foundFiles.add(files[x]);	//then add it to the list of files
			}
		}
		return foundFiles;
	}
	
	/**
	 * Given a File that represents a directory, return directories from within it.
	 * @param inputFile
	 * @return
	 */
	private static ArrayList<File> getDirs(File inputFile){
		ArrayList<File> foundDirs = new ArrayList<File>();
		File[] files = inputFile.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (files[x].isDirectory()) {		//if the file we're checking is a directory
				foundDirs.add(files[x]);		//then add it to the list of directories
			}
		}
		return foundDirs;
	}

}
