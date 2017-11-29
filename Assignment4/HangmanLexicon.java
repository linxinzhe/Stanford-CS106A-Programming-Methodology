/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.util.*;
import java.util.ArrayList;

public class HangmanLexicon {

	private ArrayList<String> lexiconList=new ArrayList();
	
	  public HangmanLexicon() {    
		  // your initialization code goes here
		  try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("./HangmanLexicon.txt"));
			while (true) {
				String line=bufferedReader.readLine();
				if(line==null) {
					break;
				}
				lexiconList.add(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return lexiconList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lexiconList.get(index);
	};
}
