/**
 * 
 */
package com.smoothstack.basics.two;

/**
 * @author max
 *
 */
public class ShapeDriver {

	/**
	 * Make some Shapes and print out their area.
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle myRectangle = new Rectangle(6.0, 4.0);
		Circle myCircle = new Circle(10.0);
		Triangle myTriangle = new Triangle(6.0, 8.0);

		System.out.print("The area of a rectangle with width 6 and height 4 is: ");
		myRectangle.display();
		System.out.print("\n");
		
		System.out.print("The area of a circle with radius 10 is: ");
		myCircle.display();
		System.out.print("\n");
		
		System.out.print("The area of a triangle with base 6 and height 8 is: ");
		myTriangle.display();
		System.out.print("\n");
	}

}
