/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {

	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;

	private static final int TILE_WIDTH = 20*5;
	private static final int TILE_HEIGHT = 20*3;

	public void run() {
		/* You fill this in. */
		double windowHeight=getHeight();
		double windowWidth=getWidth();

		{
			GRect rect=new GRect(windowWidth/2-TILE_WIDTH-TILE_SPACE/2, windowHeight/2-TILE_HEIGHT-TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);
			add(rect);

			addLabel(rect);
		}

		{
			GRect rect=new GRect(windowWidth/2+TILE_SPACE/2, windowHeight/2-TILE_HEIGHT-TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);

			addLabel(rect);
		}

		{
			GRect rect=new GRect(windowWidth/2-TILE_WIDTH-TILE_SPACE/2, windowHeight/2+TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);

			add(rect);

			addLabel(rect);
		}

		{
			GRect rect=new GRect(windowWidth/2+TILE_SPACE/2, windowHeight/2+TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);
			add(rect);

			addLabel(rect);
		}

	}

	private void addLabel(GRect rect) {
		double rectWidth=rect.getWidth();
		double rectHeihgt=rect.getHeight();
		GPoint rectPoint=rect.getLocation();
		
		GLabel label=new GLabel("CS106A");
		double labelWidth=label.getWidth();
		double labelHeihgt=label.getHeight();
		label.setLocation(rectPoint.getX()+rectWidth/2-labelWidth/2, rectPoint.getY()+rectHeihgt/2+labelHeihgt/2);
		add(label);
	}
}

