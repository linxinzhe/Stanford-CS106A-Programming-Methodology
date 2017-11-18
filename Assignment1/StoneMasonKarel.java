/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		while(frontIsClear()) {
			fixColumn();
			backToRoad();
			goNextColumn();
		}
		fixColumn();
	}
	
	private void fixColumn() {
		befacingNorth();
		safePutBeeper();
		while(frontIsClear()) {
			move();
			safePutBeeper();
		}
	}
	
	private void befacingNorth() {
		while(notFacingNorth()) {
			turnLeft();
		}
	}
	
	private void backToRoad() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		befacingEast();
	}
	
	private void befacingEast() {
		while(notFacingEast()) {
			turnLeft();
		}
	}

	@Override
	public void turnAround() {
		turnLeft();
		turnLeft();
	}

	private void goNextColumn() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
	
	private void safePutBeeper() {
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
}
