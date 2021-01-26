/**
 * 
 */
package com.smoothstack.basics.four;

import com.smoothstack.basics.two.Rectangle;

/**
 * @author max
 *
 */
public class DeadlockedThreads {

	/**
	 * Spins up two threads that are each locked on an object the other needs. This program should need to be terminated by the user.
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable threadOne, threadTwo;
		Rectangle square = new Rectangle(2, 2);
		Rectangle rect = new Rectangle(2, 3);
		
		threadOne = new Runnable() {			//define what our first thread will do
			@Override
			public void run() {
				try {
					synchronized (square) {		//it wants to get the square,
						Thread.sleep(100);		//wait a moment,
						synchronized (rect) {	//then get the rectangle before printing anything out
							System.out.println("Area of square: " + square.calculateArea());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		threadTwo = new Runnable() {			//define what our second thread will do
			@Override
			public void run() {
				try {
					synchronized (rect) {		//thread two will get the rectangle first
						Thread.sleep(100);		//then wait
						synchronized (square) {	//then try to get the square
							System.out.println("Area of rectangle: " + rect.calculateArea());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		/*
		 * Both threads are kicked off one after the other, such that threadTwo starts
		 * well within threadOne's sleep period. By the time threadOne wakes back up,
		 * threadTwo will have already taken the rectangle that threadOne wants before
		 * it prints anything. As such, the program does nothing and must be killed.
		 */
		System.out.println("Launching threads. If the program prints anything after this, something went wrong.");
		new Thread(threadOne).start();
		new Thread(threadTwo).start();
	}

}
