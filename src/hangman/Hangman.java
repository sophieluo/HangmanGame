package hangman;

import java.io.*;
import java.util.*;


public class Hangman {
	
	/**
	 * create a FileReader with the given File object
	 * need to handle exceptions
	 */
	public static void loadWords(){
		//create File object
		File words= new File("/words_clean.txt");
		
		try {
			FileReader wordsr = new FileReader(words);
		} catch (IOException e) {
			throw new RuntimeException("Error readings words file", e);
		}
 	
		try{
			//create a BufferedReader
			BufferedReader wordsrb = new BufferedReader(wordsr);
		} catch (IOException e) {
			throw new RuntimeException("Error", e);
		}
		
		
		//read a whole line
		//need to handle exceptions
		String s = wordsrb.readLine();
	}
	

	public String ToSting() {
	return "words";
	}
	
	public void newWord(){
		
	}
	
	public String status() {
		return "hello world";
		
	}
	
	public void guess(char letter) {
		
	}
	
	public boolean isOver() {
		return false;
		
	}
		
		
				
	//close after use
	wordsr.close();
	wordsrb.close();


}

