/**
 * 
 */
package com.smoothstack.basics.two;

/**
 * @author max
 *
 */
public class Triangle implements Shape {
	private double base, height = 0.0;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double calculateArea() {
		return (this.base * (this.height * 0.5));
	}

}
