/**
 * 
 */
package com.billionman.controller.materialscontroller;

/**
 * @author CTM
 *
 */
public class Test3 {
	int n;
	boolean valuseSet = false;

	synchronized int get() {
		while (!valuseSet) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Get: " + n);
		valuseSet = false;
		notify();
		return n;
	}
	
	synchronized void put(int n) {
		while (!valuseSet) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		this.n = n;
		valuseSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}
