/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import java.util.ArrayList;

import acm.program.*;
import acmx.export.java.util.Arrays;
import acmx.export.java.util.Collections;

public class SwitchPairs extends ConsoleProgram {
	public void run() {
		String[] arr= {"four", "score", "and", "seven", "years", "ago"};
		printArr(arr);
		
		ArrayList<String> arrayList=new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String string=arr[i];
			if (i!=0&&i%2==1) {
				arrayList.add(i-1, string);
			}else {
				arrayList.add(string);
			}
		}
		
		printArr(arrayList);
	}
	
	private void printArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			print(arr[i]);
			print(" ");
		}
		println();
	}
	
	private void printArr(ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			print(arr.get(i));
			print(" ");
		}
		println();
	}
}

