/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

import java.awt.Color;
import java.util.ArrayList;

public class HangmanCanvas extends GCanvas {

	private GLabel wordLabel;

	private GLabel guessLabel;

	private ArrayList<Character> inCorrectGuessList=new ArrayList();

	/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		
		int windowWidth=getWidth();
		int windowHeight=getHeight();
		
		wordLabel=new GLabel("",WORD_X,windowHeight/2+WORD_OFFSET_Y);
		add(wordLabel);
		guessLabel=new GLabel("",wordLabel.getX(),wordLabel.getY()+GUESS_OFFSET_Y);
		add(guessLabel);
	}

	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game.  The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		wordLabel.setLabel(word);
		
		String inCorrect="";
		for (int i = 0; i < inCorrectGuessList.size(); i++) {
			char c=inCorrectGuessList.get(i);
			inCorrect+=String.valueOf(c);
		}
		guessLabel.setLabel(inCorrect);
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user.  Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public void noteIncorrectGuess(char letter) {
		switch (inCorrectGuessList.size()) {
		case 0:
			drawScaffold();
			break;
		case 1:
			drawRope();
			break;
		case 2:
			drawHead();
			break;
		case 3:
			drawBody();
			break;
		case 4:
			drawLeftArm();
			break;
		case 5:
			drawRightArm();
			break;
		case 6:
			drawLeftLeg();
			break;
		case 7:
			drawRightLeg();
			break;
		default:
			break;
		}
		inCorrectGuessList.add(letter);
	}

	private GLine scaffold;
	private GLine beam;
	private GLine rope;
	private GOval head;
	private GLine body;

	private GLine leftUpperArm;
	private GLine leftLowerArm;

	private GLine rightUpperArm;
	private GLine rightLowerArm;

	private GLine leftHip;
	private GLine leftLeg;
	private GLine leftFoot;

	private GLine rightHip;
	private GLine rightLeg;
	private GLine rightFoot;

	private void drawScaffold() {
		int windowWidth=getWidth();
		int windowHeight=getHeight();
		
		scaffold=new GLine(windowWidth/2-BEAM_LENGTH, (windowHeight-SCAFFOLD_HEIGHT)/2-HANGMAN_OFFSET_Y,
				windowWidth/2-BEAM_LENGTH, (windowHeight+SCAFFOLD_HEIGHT)/2-HANGMAN_OFFSET_Y);
		scaffold.setColor(Color.BLACK);
		add(scaffold);
		
		beam=new GLine(scaffold.getX(), scaffold.getY(),
				scaffold.getX()+BEAM_LENGTH, scaffold.getY());
		add(beam);
	}

	private void drawRope() {
		rope=new GLine(beam.getX()+BEAM_LENGTH, beam.getY(),
				beam.getX()+BEAM_LENGTH , beam.getY()+ROPE_LENGTH);
		add(rope);
	}

	private void drawHead() {
		head=new GOval(rope.getX()-HEAD_RADIUS,rope.getY()+ROPE_LENGTH, 
				HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}

	private void drawBody() {
		body=new GLine(head.getX()+HEAD_RADIUS, head.getY()+HEAD_RADIUS*2, 
				head.getX()+HEAD_RADIUS, head.getY()+HEAD_RADIUS*2+BODY_LENGTH);
		add(body);
	}

	private void drawLeftArm() {
		leftUpperArm=new GLine(body.getX()-UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD, 
				body.getX(), body.getY()+ARM_OFFSET_FROM_HEAD);
		add(leftUpperArm);

		leftLowerArm=new GLine(body.getX()-UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD, 
				body.getX()-UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		add(leftLowerArm);
	}

	private void drawRightArm() {
		rightUpperArm=new GLine(body.getX(), body.getY()+ARM_OFFSET_FROM_HEAD, 
				body.getX()+UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD);
		add(rightUpperArm);

		rightLowerArm=new GLine(body.getX()+UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD, 
				body.getX()+UPPER_ARM_LENGTH, body.getY()+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		add(rightLowerArm);
	}

	private void drawLeftLeg() {
		leftHip=new GLine(body.getX()-HIP_WIDTH, body.getY()+BODY_LENGTH, 
				body.getX(), body.getY()+BODY_LENGTH);
		add(leftHip);

		leftLeg=new GLine(leftHip.getX(), leftHip.getY(), 
				leftHip.getX(), leftHip.getY()+LEG_LENGTH);
		add(leftLeg);

		leftFoot=new GLine(leftLeg.getX()-FOOT_LENGTH, leftLeg.getY()+LEG_LENGTH, 
				leftLeg.getX(), leftLeg.getY()+LEG_LENGTH);
		add(leftFoot);
	}

	private void drawRightLeg() {
		rightHip=new GLine(body.getX(), body.getY()+BODY_LENGTH,
				body.getX()+HIP_WIDTH, body.getY()+BODY_LENGTH);
		add(rightHip);

		rightLeg=new GLine(rightHip.getX()+HIP_WIDTH,rightHip.getY(),
				rightHip.getX()+HIP_WIDTH, rightHip.getY()+LEG_LENGTH);
		add(rightLeg);

		rightFoot=new GLine(rightLeg.getX(), rightLeg.getY()+LEG_LENGTH, 
				rightLeg.getX()+FOOT_LENGTH, rightLeg.getY()+LEG_LENGTH);
		add(rightFoot);
	}

	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;

	private static final int ROPE_LENGTH = 18;

	private static final int HEAD_RADIUS = 36;

	private static final int BODY_LENGTH = 144;

	private static final int ARM_OFFSET_FROM_HEAD = 28;

	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;

	private static final int HIP_WIDTH = 36;

	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	private static final int HANGMAN_OFFSET_Y = 50;
	
	private static final int WORD_X = 50;
	private static final int WORD_OFFSET_Y = (ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH)/2;

	private static final int GUESS_OFFSET_Y = 30;
}
