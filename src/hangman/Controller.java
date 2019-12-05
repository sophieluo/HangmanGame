package hangman;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * launches the game and takes user input
 * @author xiexiao@wharton.upenn.edu
 *
 */
public class Controller {

	public static void main(String[] args) {
		
		 //scanner to take user input
		 Scanner sc = new Scanner(System.in);
		 Scanner sc1 = new Scanner(System.in);
		 
		 //ask whether user wants to play traditional or evil
		 System.out.println("enter 1 for traditional hangman, 2 for evil hangman");
		 int userChoice = sc.nextInt();
		 
		 if (userChoice == 1) {
			 //initializes new traditional game
			 TraditionalHangman traditionalhangman = new TraditionalHangman("words.txt");
			 
			 ArrayList<String> lines = traditionalhangman.loadWords();
			 System.out.println(lines);
			  
			 //choose a random word from word.txt
			 traditionalhangman.randomWord(lines);
				 
			 while(true){
				 
				 //check if game is over
				 if (traditionalhangman.isOver()){
					 System.out.println(traditionalhangman.status());
					 break;
					 //if game is not over
				 } else {
						 System.out.println(traditionalhangman.status());
						 
						 //prompts user to enter a letter
						 System.out.println("Guess a letter");
						 
						 //reads the nextLine in user input and change it to lower case
						 String str = sc1.nextLine().toLowerCase();
						 
						 boolean isLetter = false;
						 
						 //get the first character of user input
						 char character = str.charAt(0);
						 
						 /**
						  * check is the character is a letter.
						  * return true if it's a letter
						  */
						 isLetter = character >= 'A' && character <= 'z';
						 
						 //checks if user input is empty
						 if (str.length() == 0){
							 System.out.println("Please enter a letter");
							 
						//checks if the first character of user input is a letter
	
						 } else if (isLetter) {
							 
							 //set the first character of user input as letter
							 char letter = str.charAt(0);
							 
							 //checks the letter
							 traditionalhangman.guess(letter);
						} else {
						
						//prompts user to enter another string
			            System.out.println("Please enter a letter. You entered something that's not a letter.");
			          }
			        }
			     }	
		 	}
		 else if (userChoice == 2) {
			//initializes new traditional game
			EvilHangman evilhangman = new EvilHangman("words.txt");
			 
			ArrayList<String> lines = evilhangman.loadWords();
			System.out.println(lines);
			  
			//choose a random word from word.txt
			String currentWord = evilhangman.randomWord(lines);
			
			//finds words with same length
			ArrayList sameLengthWords = evilhangman.findSameLength(lines, currentWord);
			
			 while(true){
				 
				 //check if game is over
				 if (evilhangman.isOver()){
					 System.out.println(evilhangman.status());
					 break;
					 //if game is not over
				 } else {
						 System.out.println(evilhangman.status());
						 
						 //prompts user to enter a letter
						 System.out.println("Guess a letter");
						 
						 //reads the nextLine in user input and change it to lower case
						 String str = sc1.nextLine().toLowerCase();
						 
						 boolean isLetter = false;
						 
						 //get the first character of user input
						 char character = str.charAt(0);
						 
						 /**
						  * check is the character is a letter.
						  * return true if it's a letter
						  */
						 isLetter = character >= 'A' && character <= 'z';
						 
						 //checks if user input is empty
						 if (str.length() == 0){
							 System.out.println("Please enter a letter");
							 
						//checks if the first character of user input is a letter
	
						 } else if (isLetter) {
							 
							 //set the first character of user input as letter
							 char letter = str.charAt(0);
							 
							 //checks the letter
							 evilhangman.guess(letter);
						} else {
						
						//prompts user to enter another string
			            System.out.println("Please enter a letter. You entered something that's not a letter.");
			          }
			        }
			     }
		 }
	}
}
