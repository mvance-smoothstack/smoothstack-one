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
public class AssignmentTwo {
	
	public static List<Integer> rightDigits(List<Integer> input) {
		List<Integer> output = input.stream().map(number -> (number % 10)).collect(Collectors.toList());
		return output;
	}
	
}
