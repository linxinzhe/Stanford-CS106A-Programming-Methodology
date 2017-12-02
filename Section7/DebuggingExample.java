/*
 * File: DebuggingExample.java
 * ----------------------------
 * This program is supposed to animate a ball that bounces off the
 * four walls. The ball should change color whenever it hits a wall.
 * The program should also display a big "Bouncing Bouncing Ball!"
 * label, centered horizontally. The label color should always match
 * the color of the ball, and both should initially be colored red. *
 * However, the program has a few errors. Use the Eclipse debugger
 * to find and fix them! */
import acm.program.*; 
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
public class DebuggingExample extends GraphicsProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private static final double MIN_DX = 2.0; 
	private static final double MAX_DX = 3.0;
	private static final double MIN_DY = 2.0;
	private static final double MAX_DY = 3.0;

	private static final double PAUSE = 15.0;
	private static final int TEXT_HEIGHT = 100;

	private static final int NUM_COLORS = 5;

	private static final int BALL_RADIUS = 6;
	private GLabel text;

	private Color nextColor;

	public void run() { 
		double dx = rgen.nextDouble(MIN_DX, MAX_DX); 
		double dy = rgen.nextDouble(MIN_DY, MAX_DY);
		setupLabel(); 
		GOval ball = setupBall();
		while (true) {
			ball.move(dx, dy);
//			checkForCollisions(ball, dx, dy);
			if (ball.getX() <= 0 || ball.getX() >= (getWidth() - (BALL_RADIUS * 2))) {
				dx = -dx;
				ball.move(dx, 0); // Move the ball out of the wall 
				Color nextColor = getRandomNewColor(ball.getColor()); 
				ball.setColor(nextColor);
				text.setColor(nextColor);
			}
			if (ball.getY() <= 0 || ball.getY() >= (getHeight() - (BALL_RADIUS * 2))) { 
				dy = -dy;
				ball.move(0, dy); // Move the ball out of the wall 
				Color nextColor = getRandomNewColor(ball.getColor()); 
				ball.setColor(nextColor);
				text.setColor(nextColor);
			} 
			pause(PAUSE);
		} 
	}

	private void setupLabel() {
		text = new GLabel("Bouncing Bouncing Ball!");
		double x = (getWidth() / 2.0) - (text.getWidth()/2);
		double y = (getHeight() / 2.0) - (text.getHeight() / 2.0); 
		text.setFont(new Font("Arial", Font.BOLD, 32));
		text.setColor(Color.RED);
		text.setLocation(x, y);
		add(text);
	}

	private GOval setupBall() {
		GOval ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2); 
		ball.setFilled(true);
		ball.setColor(Color.RED);
		double x = rgen.nextDouble(0, getWidth() - (BALL_RADIUS * 2));
		double y = rgen.nextDouble(0, getHeight() - (BALL_RADIUS * 2)); 
		ball.setLocation(x, y);
		add(ball);
		return ball;
	}

	/*
	 * If the ball collides with one of the walls, change the
	 * corresponding direction and change the color. Note that it's
	 * possible to bounce off two walls (e.g. the corner) simultaneously. */
//	private void checkForCollisions(GOval ball, double dx, double dy) {
//		if (ball.getX() <= 0 || ball.getX() >= (getWidth() - (BALL_RADIUS * 2))) {
//			dx = -dx;
//			ball.move(dx, 0); // Move the ball out of the wall 
//			Color nextColor = getRandomNewColor(ball.getColor()); 
//			ball.setColor(nextColor);
//			text.setColor(nextColor);
//		}
//		if (ball.getY() <= 0 || ball.getY() >= (getHeight() - (BALL_RADIUS * 2))) { 
//			dy = -dy;
//			ball.move(0, dy); // Move the ball out of the wall 
//			Color nextColor = getRandomNewColor(ball.getColor()); 
//			ball.setColor(nextColor);
//			text.setColor(nextColor);
//		} 
//	}

	/*
	 * Choose a random color that is different than "prevColor" */
	private Color getRandomNewColor(Color prevColor) { 
		while (true) {
			Color newColor;
			int color = rgen.nextInt(0, NUM_COLORS - 1);
			switch(color) { 
			case 0:
				newColor = Color.RED; 
				break;
			case 1:
				newColor = Color.ORANGE; 
				break;
			case 2:
				newColor = Color.YELLOW; 
				break;
			case 3:
				newColor = Color.GREEN; 
				break;
			case 4:
				newColor = Color.BLUE; 
				break;
			default:
				newColor = Color.BLACK;
				break;
			}
			// If the new color is the same as the previous color, 
			// we’re done. Otherwise, choose again.
			if (!newColor.equals(prevColor)) return newColor;
		}
	}
}
