/**
 * 
 */
package com.smoothstack.basics.two;

/**
 * @author max
 *
 */
public class Circle implements Shape {
	private double radius = 0.0;

	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		return (Math.PI * Math.pow(radius, 2.0));
	}

}
