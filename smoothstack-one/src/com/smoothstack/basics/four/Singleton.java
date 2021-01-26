/**
 * 
 */
package com.smoothstack.basics.four;

/**
 * Example implementation of the singleton design pattern.
 * @author max
 * 
 */
public class Singleton {
	//The volatile keyword helps make accessing a variable thread-safe.
	volatile private static Singleton theInstance = null;
	
	//Private constructor stops anyone else from making more instances of this.
	private Singleton() {
		System.out.println("Creating a new singleton instance.");
	}
	
	public static Singleton getInstance() {
		if (theInstance == null) {					//if the instance hasn't been created yet...
			synchronized (Singleton.class) {		//drop into a synchronized block so multiple threads can't do this at the same time
				if (theInstance == null) {			//checking again if the instance isn't yet created
					theInstance = new Singleton();	//if not, then finally create it
				}
			}
		}
		return theInstance;					//either way, return our one instance
	}
}
