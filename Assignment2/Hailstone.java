/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		int num=readInt("Enter a number:");
		while(num!=1) {
			if (num%2==0) {
				int result=num/2;
				println(String.valueOf(num)+" is even,so I take half: "+String.valueOf(result));
				num=result;
			}else {
				int result=3*num+1;
				println(String.valueOf(num)+" is odd,so I make 3n+1: "+String.valueOf(result));
				num=result;
			}
		}
			
	}
}

