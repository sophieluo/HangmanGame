package hangman;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;


public abstract class Hangman {
		
	/**
	 * Name of file to open and read.
	 */
	public String filename;
	
	/**
	 * total turns the user has
	 */
	public static final int MAX = 10;
	
	/**
	 * a random word chosen by computer each time
	 */
	public String currentWord;
	
	/**
	 * displays the game board
	 */
	public ArrayList<Character> display;
	
	/**
	 * arraylist of characters user already guessed (so don't penalize them for entering the wrong character twice
	 */
	private ArrayList<Character> guessed;
	
	/**
	 * number of guesses remaining
	 */
	private int remaining;
	
	
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
				
				//first strip whitespaces before and after
				line = line.strip();
//				System.out.println(line);
				
				if(!line.isEmpty()) {
					
					//if starts with uppercase letters
					if(Character.isUpperCase(line.charAt(0))) {
						//skips to the next line
						line = file.readLine();
					}
					//if ends with .
					else if(line.charAt(line.length()-1) == '.') {
						line = file.readLine();
					}
					//if contains '
					else if(line.indexOf('\'') >= 0){
						line = file.readLine();
					}
					//if contains -
					else if(line.indexOf('-') >= 0) {
						line = file.readLine();
					}
					//if contains whitespace
					else if(line.indexOf(' ') >= 0) {
						line = file.readLine();
					}
					//if contains number
					//should have used regex
					else if(line.indexOf('0') >= 0
							|| line.indexOf('1') >= 0
							|| line.indexOf('2') >= 0
							|| line.indexOf('3') >= 0
							|| line.indexOf('4') >= 0
							|| line.indexOf('5') >= 0
							|| line.indexOf('6') >= 0
							|| line.indexOf('7') >= 0
							|| line.indexOf('8') >= 0
							|| line.indexOf('9') >= 0
							
							) {
						line = file.readLine();
					}
					else {
						lines.add(line);
					}
				}
				line = file.readLine();
				} 
			}
			//standard exception handling
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

}
