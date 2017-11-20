/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		println("This program finds the largest and smallest numbers");

		int smallest=Integer.MAX_VALUE;
		int largest=Integer.MIN_VALUE;
		while(true) {
			int num=readInt("?");
			if(num==0) {
				break;
			}
			if(num<smallest) {
				smallest=num;
			}
			if(num>largest) {
				largest=num;
			}
		}
		
		if (Integer.MAX_VALUE==smallest&&largest==Integer.MIN_VALUE) {
			println("No number input yet.");
		}else {
			println("smallest:"+String.valueOf(smallest));
			println("largest:"+String.valueOf(largest));
		}
	}
}

