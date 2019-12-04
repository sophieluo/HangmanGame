package hangman;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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
	
	private String display;
	
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
		display = "";
		
		for (int j = 0; j < currentWord.length(); j++) {
			display = display + '_';
		}
		
		remaining = MAX;
		guessed = new ArrayList<>();	 	
	}

	
	public String status() {
		if (remaining == 1) {
			return "LOST";
		} else if (display.indexOf("_") == -1) {
			return "WON";
		}
		
		String status = null;
		
		for (int i = 0; i < MAX; i++) {
		      if (i < remaining){
		        status = status + "*";
		      }else{
		        status = status + " ";
		      }
		    }
		status = status + "|";
		
		return display + status;
 	}
	
	public void guess(char letter) {
		
	}
	
	public boolean isOver() {
		return false;
		
	}
		



}

