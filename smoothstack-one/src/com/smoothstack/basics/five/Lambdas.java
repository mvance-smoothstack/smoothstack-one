/**
 * 
 */
package com.smoothstack.basics.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author max
 *
 */
public class Lambdas {

	/**
	 * Basic operations with lambdas and a list of strings.
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> myStrings = Arrays.asList("foo", "bar", "baz", "This is an example string", "Java 8 added a lot of new features", "Maxwell Vance");
		List<Integer> myIntList = new ArrayList<Integer>();
		for (int x = 1; x <= 10; x++) {
			myIntList.add(x);
		}
		List<String> moreStrings = Arrays.asList("oiv", "aoo", "nmt", "qlurva", "valruiwnvab", "btn", "pogdbj", "qneorif", "aiontoi", "apoinpin", "anr", "ucn", "lnd", "rinoew", "airewon", "amw");
		
		System.out.println("Strings, shortest to longest:");
		myStrings.stream().sorted(Comparator.comparingInt(String::length)).forEach(str -> System.out.println(str));
		System.out.println("--------------------------------------------------");
		
		System.out.println("Strings, longest to shortest:");
		myStrings.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(str -> System.out.println(str));
		System.out.println("--------------------------------------------------");
		
		System.out.println("Strings, alphabetically by first character (case-sensitive):");
		myStrings.stream().sorted(Comparator.comparing(str -> str.charAt(0))).forEach(str -> System.out.println(str));
		System.out.println("--------------------------------------------------");
		
		//false comes before true when sorting
		System.out.println("Strings with the letter \"e\" before strings without:");
		myStrings.stream().sorted(Comparator.comparing(str -> !(str.contains("e")))).forEach(str -> System.out.println(str));
		System.out.println("--------------------------------------------------");
		
		System.out.println("Strings with the letter \"e\" before strings without, with a helper method:");
		myStrings.stream().sorted(Comparator.comparing(str -> checkForNoE(str))).forEach(str -> System.out.println(str));
		System.out.println("--------------------------------------------------");
		
		System.out.println("Comma separated integers indicating whether they're even or odd:");
		String numberStr = myIntList.stream().map(num -> commaSeparatedParity(num)).collect(Collectors.joining());
		numberStr = numberStr.substring(0, numberStr.length() - 1);	//snip off the last comma
		//TODO: Consider whether there's a way to do the above as part of the stream functions.
		System.out.println(numberStr);
		System.out.println("--------------------------------------------------");
		
		System.out.println("Strings that start with \"a\" and are three characters long:");
		List<String> filteredStrings = stringsThreeLongAndStartingWithA(moreStrings);
		//enhanced for loop syntax: for (TypeOfElement elementIdentifier : collectionOfElements)
		for (String str : filteredStrings) {
			System.out.print(str + " ");
		}
	}
	
	public static boolean checkForNoE(String str) {
		if (str.contains("e")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String commaSeparatedParity(int num) {
		String ret = "";
		if (num % 2 == 0) {	//if it's even
			ret = ret + "e";
		} else {			//if it's odd
			ret = ret + "o";
		}
		ret = ret + num + ",";
		return ret;
	}
	
	public static List<String> stringsThreeLongAndStartingWithA(List<String> input) {
		return input.stream().filter(str -> str.charAt(0) == 'a').filter(str -> str.length() == 3).collect(Collectors.toList());
	}

}
