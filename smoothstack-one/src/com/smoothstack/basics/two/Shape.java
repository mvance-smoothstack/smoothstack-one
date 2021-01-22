/**
 * 
 */
package com.smoothstack.basics.two;

/**
 * @author max
 *
 */
public interface Shape {
	double calculateArea();
	
	/**
	 * Prints out the area of the shape. Depends on the shape's calculateArea implementation.
	 */
	default void display() {
		System.out.print(calculateArea());	//print it on the same line
	}
}
