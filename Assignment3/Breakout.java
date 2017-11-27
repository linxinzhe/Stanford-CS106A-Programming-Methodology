/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.ArrayList;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  IMPORTANT NOTE:
  * ON SOME PLATFORMS THESE CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS
  * OF THE GRAPHICS CANVAS.  Use getWidth() and getHeight() to get the 
  * dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  IMPORTANT NOTE: ON SOME PLATFORMS THESE 
  * CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS OF THE GRAPHICS
  * CANVAS.  Use getWidth() and getHeight() to get the dimensions of
  * the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

	private GRect paddle;
	private GOval ballOval;
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance(); 
	private int windowHeight;
	private int windowWidth;
	private GLabel scoreboard;
	private int turn=1;
	private int brickCount=10*10;
	
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		windowHeight=getHeight();
		windowWidth=getWidth();
		
		setUpBricks();
		setUpPaddle();
		setUpScoreboard();
		while(turn<=NTURNS) {
			setUpBall();

			ballMove();
		}
		
		scoreboard.setLabel("GameOver!");
	}

	private void setUpScoreboard() {
		GLabel label=new GLabel("Term:"+String.valueOf(turn));
		label.setLocation(10, 10);
		scoreboard=label;
		add(label);
}

	private void ballMove() {
		vx = rgen.nextDouble(1.0, 3.0); 
		if (rgen.nextBoolean(0.5)) vx = -vx; 
		vy=3.0;
		while(true) {
			ballOval.move(vx,vy);
			
			if (ballOval.getX()<0|| (ballOval.getX()+BALL_RADIUS*2)>windowWidth) {
				vx=-vx;
			}
			if (ballOval.getY()<0) {
				vy=-vy;
			}
			if ((ballOval.getY()+BALL_RADIUS*2)>windowHeight) {
//				game lost
				turn+=1;
				scoreboard.setLabel("Term:"+String.valueOf(turn));
				remove(ballOval);
				break;
			}
			
			GObject collider=getCollidingObject();
			if (collider!=null&&collider==paddle) {
				vy=-vy;
			}else if(collider!=null&&collider==scoreboard) {
//				don't remove scoreboard
			}else if(collider!=null) {
				vy=-vy;
				remove(collider);
				brickCount-=1;
			}
			
			if (brickCount==0) {
//				game win
				scoreboard.setLabel("You Win!");
				break;
			}
			
			pause(10);
		}
	}

	private GObject getCollidingObject() {
		double x=ballOval.getX();
		double y=ballOval.getY();
		GPoint upperLeftPoint=new GPoint(x,y);
		GPoint upperRightPoint=new GPoint(x+2*BALL_RADIUS,y);
		GPoint lowerLeftPoint=new GPoint(x,y+2*BALL_RADIUS);
		GPoint lowerRightPoint=new GPoint(x+2*BALL_RADIUS,y+2*BALL_RADIUS);
		ArrayList<GPoint> pointList=new ArrayList<GPoint>();
		pointList.add(upperLeftPoint);
		pointList.add(upperRightPoint);
		pointList.add(lowerLeftPoint);
		pointList.add(lowerRightPoint);
		
		for(GPoint point:pointList) {
			GObject object=getElementAt(upperLeftPoint);
			if (object!=null) {
				return object;
			}
		}
		return null;
	}

	private void setUpBall() {
		GOval oval=new GOval((windowWidth-BALL_RADIUS*2)/2,(windowHeight-BALL_RADIUS*2)/2,
				BALL_RADIUS*2, BALL_RADIUS*2);
		oval.setColor(Color.BLACK);
		oval.setFilled(true);
		ballOval=oval;
		add(oval);
	}

	private void setUpPaddle() {
		GRect gRect=new GRect(
				(windowWidth-PADDLE_WIDTH)/2,windowHeight-PADDLE_HEIGHT-BRICK_Y_OFFSET,
				PADDLE_WIDTH, PADDLE_HEIGHT);
		gRect.setColor(Color.BLACK);
		gRect.setFilled(true);
		add(gRect);
		paddle=gRect;
		addMouseListeners();
	}

	private void setUpBricks() {
		Color[] colorList = {Color.RED,Color.RED,Color.ORANGE,Color.ORANGE,Color.YELLOW,Color.YELLOW,Color.GREEN,Color.GREEN,Color.CYAN,Color.CYAN};
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				GRect gRect=new GRect(
						j*(BRICK_WIDTH+BRICK_SEP),BRICK_Y_OFFSET+i*(BRICK_HEIGHT+BRICK_SEP),
						BRICK_WIDTH, BRICK_HEIGHT);
				gRect.setColor(colorList[i]);
				gRect.setFilled(true);
				add(gRect);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		paddle.move(e.getX()-paddle.getX(), 0);
	}

}
