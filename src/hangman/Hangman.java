package hangman;

import java.io.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;


public class Hangman {
	
	/**
	 * Name of file to open and read.
	 */
	private String filename;
	
	/**
	 * total turns the user has
	 */
	private static final int TOTAL_TRIALS = 10;
	
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

	
	public void randomWord(){
		Random rd = new Random();
		 	
	}

	
	public String status() {
		return "hello world";
		
	}
	
	public void guess(char letter) {
		
	}
	
	public boolean isOver() {
		return false;
		
	}
		



}

