/**
 * 
 */
package com.smoothstack.basics.weekone;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author max
 *
 */
public class AssignmentThree {
	
	public static List<Integer> doubleInts(List<Integer> input) {
		List<Integer> output = input.stream().map(number -> (number * 2)).collect(Collectors.toList());
		return output;
	}

}
