/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	HangmanLexicon lexicon = new HangmanLexicon();
	RandomGenerator randomGenerator=new RandomGenerator();

	String wordGuess="";
	String wordHidden="";

	int guessLeft=8;
	
	private HangmanCanvas canvas;
	
	public void init() {    
		canvas = new HangmanCanvas();  
		add(canvas); 
	} 

	public void run() {
		canvas.reset();
		
		randomGenerator.setSeed(1);
		wordGuess=lexicon.getWord(randomGenerator.nextInt(0, lexicon.getWordCount()));
		
		wordHidden=hideWordWithDash(wordGuess);

		println("Welcome to Hangman!");
		
		while(guessLeft>0) {
			println("The word now looks like this:"+wordHidden);
			println("You have "+guessLeft+" guesses left");
			
			String userChar=readLine("Your guess:").toUpperCase();
			
			if (userChar.length()==1) {
				if(isInWord(wordGuess,userChar)) {	
					String wordHiddenAfter=revealGuess(wordGuess,wordHidden,userChar);
					if (wordHiddenAfter.equals(wordHidden)) {
						continue;
					}else {
						wordHidden=wordHiddenAfter;
					}
					println("That guess is correct");
					
					//win
					if (wordHidden.equals(wordGuess)) {
						println("You guessed the word:"+wordGuess);
						println("You win.");
						break;
					}	
				}else {
					println("There are no "+userChar+"'s in the word.");
					canvas.noteIncorrectGuess(userChar.charAt(0));
				}
			}else {
				println("Input error!Please try agian.");
			}
			
			canvas.displayWord(wordHidden);
			guessLeft-=1;
		}
		//game over
		canvas.displayWord(wordHidden);
		if (guessLeft==0) {
			println("You lose.");
		}
	}

	private String revealGuess(String word, String hidden, String userChar) {
		for (int i = 0; i < word.length(); i++) {
			String c=word.substring(i, i+1);
			if (c.equals(userChar)) {
				if (i==word.length()-1) {
					hidden=hidden.substring(0,i)+c;
				}else {
					hidden=hidden.substring(0,i)+c+hidden.substring(i+1);
				}
			}
		}
		return hidden;
	}

	private boolean isInWord(String word,String c) {
		for (int i = 0; i < word.length(); i++) {
			if(c.equals(word.substring(i,i+1))) {
				return true;
			}
		}
		return false;
	}

	private String hideWordWithDash(String word) {
		String wordHidden="";
		for (int i = 0; i < word.length(); i++) {
			wordHidden+="-";
		}
		return wordHidden;
	}

}
