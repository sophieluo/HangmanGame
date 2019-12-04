package hangman;

import java.io.*;
import java.util.Random;
import java.util.List;
import java.nio.file.Files;


public class Hangman {
	
	private static final int TOTAL_TRIALS = 10;
	private static List<String> wordsList;
	
	/**
	 * create a FileReader with the given File object
	 * need to handle exceptions
	 */
	public static void loadWords(){
		//create File object
		File wordsFile = new File("words_clean.txt");
//		System.out.println(wordsFile);
		
		//define file reader
		FileReader fileReader = null;
		
		//define buffered reader
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(wordsFile);
			System.out.println(fileReader);
			
			bufferedReader = new BufferedReader(fileReader);
			
			System.out.println(bufferedReader);
					
//			while ((bufferedReader.readLine()) != null) {
//				for (int i = 0; i < bufferedReader.length; i++) {
//					wordsList.push(bufferedReader.nextLine());
//				}
//				
//			}
		} catch (FileNotFoundException e) {
			
			//gets and prints filename
			System.out.println("Sorry, not found.");
		} catch (IOException e) {
			
			//prints the error message and info about which line
			e.printStackTrace();
		} finally {
			
			try {
				fileReader.close();
				bufferedReader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//read a whole line
//		String s = bufferedReader.readLine();
	}
	
	public String ToSting() {
		return "words";
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

