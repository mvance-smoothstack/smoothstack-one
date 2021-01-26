/**
 * 
 */
package com.smoothstack.basics.four;

/**
 * @author max
 *
 */
public class SingletonDriver {

	/**
	 * Uses the Singleton class and tries to get multiple instances, it should return the same instance.
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton singletonOne, singletonTwo;
		singletonOne = Singleton.getInstance();
		singletonTwo = Singleton.getInstance();
		System.out.println("Singleton one's hashcode is: " + singletonOne.hashCode());
		System.out.println("Singleton two's hashcode is: " + singletonTwo.hashCode());
		System.out.println("If those two hashcodes are the same then Singleton correctly created only one instance of itself.");
	}

}
