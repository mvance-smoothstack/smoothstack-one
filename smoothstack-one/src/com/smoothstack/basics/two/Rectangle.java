/**
 * 
 */
package com.smoothstack.basics.two;

/**
 * @author max
 *
 */
public class Rectangle implements Shape {
	private double width, length = 0.0;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		return (this.width * this.length);
	}

}
