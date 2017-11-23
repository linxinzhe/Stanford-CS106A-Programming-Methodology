/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import com.sun.java.swing.plaf.windows.resources.windows;

import acm.graphics.GOval;
import acm.program.*;
import acm.util.RandomGenerator;

public class GenCircle extends GraphicsProgram {
	public void run() {
		RandomGenerator generator = RandomGenerator.getInstance();
//		generator.setSeed(1);
		
		for (int i = 0; i < 10; i++) {
			int width = getWidth();
			int height = getHeight();
			
			int radius=generator.nextInt(5, 50);
			
			int x=generator.nextInt(0, width-radius*2);
			int y=generator.nextInt(0, height-radius*2);
			
			GOval gOval = new GOval(x, y,radius*2,radius*2);
			gOval.setFillColor(generator.nextColor());
			gOval.setFilled(true);
			add(gOval);
		}
	}
}

