/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public static final double ONE_INCH=72.0;
	public static final double OUTER_CIRLE_RADIUS=ONE_INCH;
	public static final double MIDDLE_CIRLE_RADIUS=ONE_INCH*0.65;
	public static final double INNER_CIRLE_RADIUS=ONE_INCH*0.3;
	public void run() {
		/* You fill this in. */
		int windowHeight=getHeight();
		int windowWidth=getWidth();
		
		GOval outerOval=new GOval(windowWidth/2-OUTER_CIRLE_RADIUS/2, windowHeight/2-OUTER_CIRLE_RADIUS/2,OUTER_CIRLE_RADIUS,OUTER_CIRLE_RADIUS);
		outerOval.setFillColor(Color.red);
		outerOval.setColor(Color.red);
		outerOval.setFilled(true);
		add(outerOval);
		
		GOval middleOval=new GOval(windowWidth/2-MIDDLE_CIRLE_RADIUS/2, windowHeight/2-MIDDLE_CIRLE_RADIUS/2,MIDDLE_CIRLE_RADIUS,MIDDLE_CIRLE_RADIUS);
		middleOval.setFillColor(Color.white);
		middleOval.setColor(Color.white);
		middleOval.setFilled(true);
		add(middleOval);
		
		GOval innerOval=new GOval(windowWidth/2-INNER_CIRLE_RADIUS/2, windowHeight/2-INNER_CIRLE_RADIUS/2,INNER_CIRLE_RADIUS,INNER_CIRLE_RADIUS);
		innerOval.setFillColor(Color.red);
		innerOval.setColor(Color.red);
		innerOval.setFilled(true);
		add(innerOval);
	}
}
