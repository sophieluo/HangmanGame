package hangman;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;


public class EvilHangman extends Hangman {
	
	public EvilHangman(String filename) {
		this.filename = filename;
	}
	
	private ArrayList<Character> guessed;
	
	private int remaining;
	
	/**
	 * word string of the same length of currentWord
	 */
	private ArrayList<String> sameLengthWords;	
	
	/**
	 * this part needs to be changed
	 * @param lines
	 * @return
	 */
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
	
	/**
	 * finds and returns the words from list that have the same length of currentWord
	 * @return
	 */
	public ArrayList<String> findSameLength(ArrayList<String> lines, String currentWord){
		ArrayList<String> sameLengthWords = new ArrayList<String>();
		int length = currentWord.length();
		
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).length() == length) {
				sameLengthWords.add(lines.get(i));
			}
		}			
		return sameLengthWords;
	}
	
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
	
	
	/**
	 * checks if game is over
	 * @return a boolean. true -> game over; false -> continue play
	 */
	public boolean isOver() {
		return remaining == 0;
	}

	
}
