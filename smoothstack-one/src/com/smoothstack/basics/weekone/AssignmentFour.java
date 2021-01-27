package com.smoothstack.basics.weekone;

import java.util.List;
import java.util.stream.Collectors;

public class AssignmentFour {

	public static List<String> noX(List<String> input) {
		List<String> output = input.stream().map(str -> str.replaceAll("x", "")).collect(Collectors.toList());
		return output;
	}
	
	
}
