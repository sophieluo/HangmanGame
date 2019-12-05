package hangman;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class TraditionalHangman extends Hangman {

	public TraditionalHangman(String filename) {
		this.filename = filename;
	} 
	
	/**
	 * 
	 * @param lines
	 * @return a string currentWord, a word chosen randomly from lines list
	 */
	//I think this can be reused
	public String randomWord(ArrayList<String> lines){
		Random rd = new Random();
		
		int i = rd.nextInt(lines.size());
		
		currentWord = lines.get(i);
		display = new ArrayList<Character>();
		
		for (int j = 0; j < currentWord.length(); j++) {
			display.add('_');
		}
		
		remaining = MAX;
		guessed = new ArrayList<Character>();
		
		return currentWord;

	}

	private ArrayList<Character> guessed;
	
	private int remaining;

	/**
	 * prints the game board
	 * @return a string that's a visual presentation of the game board
	 */
	
	public String status() {
		
		String status = "remaining lives: ";
		
		for (int i = 0; i < MAX; i++) {
		      if (i < remaining){
		        status = status + "*";
		      }else{
		        status = status + " ";
		      }
		    }
		
		status = status + "|";
		
		status = display + status;
		
		return status;
 	}
	
	/**
	 * takes a user input, letter, and checks if this letter is contained in currentWord
	 * @param letter
	 */
	public void guess(char letter) {
		if (guessed.contains(letter)) {
		      return;
		    }
		    guessed.add(letter);
		    if (currentWord.indexOf(letter) != -1){
		      for (int i = 0; i < display.size(); i++) {
		        if (letter == currentWord.charAt(i)){
		        	display.set(i,letter);
		        }
		      }
		    }else{
		      remaining--;
		    }
	}
		
}
