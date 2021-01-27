/**
 * 
 */
package com.smoothstack.basics.four;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author max
 *
 */
public class ProducerConsumer {
	static LinkedList<Integer> myNumbers = new LinkedList<Integer>();
	
	/**
	 * Runs two threads: one that puts random numbers into a list and another that prints them out.
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable producer, consumer;
		Random myRandom = new Random();
		
		//Producer thread. Adds random numbers to the myNumbers list.
		producer = new Runnable() {
			@Override
			public void run() {
				while (true) {	//infinite loop
					int newNumber = myRandom.nextInt(1000);
					myNumbers.add(newNumber);
					System.out.println("Added a new number: " + newNumber);
					try {
						Thread.sleep(100 + newNumber);	//semi-random sleep interval so the threads aren't perfectly interacting one after another
					} catch (InterruptedException e) {
						System.err.println("Producer thread got interrupted while sleeping!");
						e.printStackTrace();
					}
				}
			}
		};
		
		//Consumer thread, gets numbers off the start of the list and prints them out.
		consumer = new Runnable() {
			@Override
			public void run() {
				while (true) {	//infinite loop
					if (myNumbers.isEmpty()) {	//if there are no numbers to consume
						System.out.println("No numbers to consume. Sleeping...");
					} else {
						int firstNumber = myNumbers.pop();	//get the first number off the list
						System.out.println("Got a number off the list: " + firstNumber);
					}	//whether empty or not, continue to sleep
					try {
						/*
						 * This thread has a fixed sleep interval that will be longer than many of
						 * producer's sleeps, but sometimes might go faster than producer. This
						 * demonstrates the condition where consumer should sleep if the list is empty.
						 */
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.err.println("Consumer thread got interrupted while sleeping!");
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
