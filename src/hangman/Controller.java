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
		//initializes new game
		 TraditionalHangman hangman = new TraditionalHangman("words.txt");
		 
		 ArrayList<String> lines = hangman.loadWords();
		 System.out.println(lines);
		 
		 //scanner to take user input
		 Scanner sc = new Scanner(System.in);
		 	 
		 //choose a random word from word.txt
		 hangman.randomWord(lines);
			 
		 while(true){
			 
			 //check if game is over
			 if (hangman.isOver()){
				 System.out.println(hangman.status());
				 break;
				 //if game is not over
			 } else {
					 System.out.println(hangman.status());
					 
					 //prompts user to enter a letter
					 System.out.println("Guess a letter");
					 
					 //reads the nextLine in user input and change it to lower case
					 String str = sc.nextLine().toLowerCase();
					 
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
						 hangman.guess(letter);
					} else {
					
					//prompts user to enter another string
		            System.out.println("Please enter a letter. You entered something that's not a letter.");
		          }
		        }
		      }	
	}

}
