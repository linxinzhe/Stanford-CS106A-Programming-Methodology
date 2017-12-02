/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class BoxDiagram extends GraphicsProgram {
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;

	ArrayList<MyBox> myBoxList=new ArrayList<>();
	
	JButton addButton;
	JTextField textField;
	JButton removeButton;
	JButton clearButton;

	public void run() {
		createComponents();

		addActionListeners();
		addMouseListeners();
		addKeyListeners();
	}

	private void createComponents() {
		add(new JLabel("Name"),SOUTH);

		textField = new JTextField(20);
		add(textField,SOUTH);

		addButton=new JButton("Add");
		addButton.addActionListener(this);
		add(addButton,SOUTH);

		removeButton=new JButton("Remove");
		add(removeButton,SOUTH);

		clearButton=new JButton("Clear");
		add(clearButton,SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "Add":
			createBox();
			break;
		case "Remove":
			removeBox();
			break;
		case "Clear":
			removeAll();
			break;
		default:
			break;
		}
	}
	
	private void removeBox() {
		String text=textField.getText();
		for (MyBox myBox : myBoxList) {
			if (text.equals(myBox.name)) {
				remove(myBox);
			}
		}
	}

	private GObject object;
	 
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		object = getElementAt(e.getX(),e.getY());
		if (object!=null) {
			object.sendToFront();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		object = getElementAt(e.getX(),e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		if (object!=null) {
			object.move(e.getX()-object.getX(), e.getY()-object.getY());
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			createBox();
		}
	}

	private void createBox() {
		String text=textField.getText();
		MyBox box=new MyBox(text, BOX_WIDTH, BOX_HEIGHT);
		int windowWidth = getWidth();
		int windowHeight = getHeight();
		myBoxList.add(box);
		add(box,windowWidth/2,windowHeight/2);
	}

	class MyBox extends GCompound{
		public String name="";
		public MyBox(String text,double width,double height) {
			this.name=text;
			GRect box=new GRect(0,0,width,height);
			GLabel label=new GLabel(text);
			add(box);
			add(label,box.getX()+width/2-label.getWidth()/2,box.getY()+height/2+label.getHeight()/2);
		}
	}
}

