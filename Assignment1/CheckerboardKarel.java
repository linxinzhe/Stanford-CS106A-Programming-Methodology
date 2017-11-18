/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	int count=0;
	
	// You fill in this part
	public void run() {
		putBeeper();
		
		while(true) {
			moveToWall();
			if(isEnd()) {
				break;
			}else {
				moveToNextStreet();
			}
		}
	}

	private void moveToNextStreet() {
		beFacingNorth();
		if (frontIsClear()) {
			move();
			if (leftIsClear()) {
				turnLeft();
			}else if(rightIsClear()) {
				turnRight();
			}
		}
	}

	private boolean isEnd() {
		beFacingNorth();
		return (frontIsBlocked()&&leftIsBlocked())||(frontIsBlocked()&&rightIsBlocked());
	}

	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	
	@Override
	public void move() {
		super.move();
		count++;
		if (count%2==0) {
			putBeeper();
		}
	}
	
	@Override
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	private void beFacingNorth() {
		while (notFacingNorth()) {
			turnLeft();
		}
	}
}
