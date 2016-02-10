package com.billionman.controller;

import java.util.ArrayList;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrlist = new ArrayList<Integer>();

		// use add() method to add elements in the list
		arrlist.add(15);
		arrlist.add(20);
		arrlist.add(25);
		arrlist.add(22);

		arrlist.add(arrlist.size(), arrlist.get(arrlist.size()-1));
		for (int i = arrlist.size()-2; i >= 0; i--) {
			int obj = arrlist.get(i);
			arrlist.set(i+1, obj);
		}

		for (Integer number : arrlist) {
			System.out.println("Number = " + number);
		}
	}

}
