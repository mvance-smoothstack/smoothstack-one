package com.smoothstack.basics.four;

import java.util.LinkedList;

public class EmptyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> listOne = new LinkedList<Integer>();
		LinkedList<Integer> listTwo = new LinkedList<Integer>();
		listOne.add(0);
		System.out.println("List one is empty: " + listOne.isEmpty());
		System.out.println("List two is empty: " + listTwo.isEmpty());
	}

}
