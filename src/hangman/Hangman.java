package hangman;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;


public class Hangman {
	
	/**
	 * Name of file to open and read.
	 */
	private String filename;
	
	/**
	 * total turns the user has
	 */
	private static final int MAX = 10;
	
	/**
	 * a random word chosen by computer each time
	 */
	private String currentWord;
	
	private ArrayList<Character> display;
	
	private ArrayList<Character> guessed;
	
	private int remaining;
	
	public Hangman(String filename) {
		this.filename = filename;
	}
	
	/**
	 * opens and reads the data in fileName,
	 * stores each line as an element into a list,
	 * need to handle exceptions
	 * @return a list of lines.
	 */
	public ArrayList<String> loadWords() {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		BufferedReader file = null;
		
		try {
			file = new BufferedReader(new FileReader(new File(filename)));
			
			String line = file.readLine();
			
			while(line != null) {
				if(!line.isEmpty()) {
					lines.add(line);
				}
				line = file.readLine();
				} 
			}
			catch(FileNotFoundException e ) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					file.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return lines;		
	}

	
	public void randomWord(ArrayList<String> lines){
		Random rd = new Random();
		
		int i = rd.nextInt(lines.size());
		
		currentWord = lines.get(i);
		display = new ArrayList<Character>();
		
		for (int j = 0; j < currentWord.length(); j++) {
			display.add('_');
		}
		
		remaining = MAX;
		guessed = new ArrayList<Character>();	 	
	}

	
	public String status() {
		if (remaining == 1) {
			return "LOST";
		} else if (display.indexOf('_') == -1) {
			return "WON";
		}
		
		String status = "remaining lives: ";
		
		for (int i = 0; i < MAX; i++) {
		      if (i < remaining){
		        status = status + "*";
		      }else{
		        status = status + " ";
		      }
		    }
		
		return display + status;
 	}
	
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
	
	
	public boolean isOver() {
		return remaining == 0;
	}
		

}

