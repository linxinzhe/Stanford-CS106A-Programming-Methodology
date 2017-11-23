import java.awt.Event;
import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class DrawLine extends GraphicsProgram{
	
	private GLine line;
	
	public void init() {
		addMouseListeners();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		line=new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		line.setEndPoint(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		super.mouseReleased(e);
		line.setEndPoint(e.getX(), e.getY());
	}
}
