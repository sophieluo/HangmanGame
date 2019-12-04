package hangman;

import java.util.Scanner;


/**
 * launches the game and takes user input
 * @author Sophie_Luo
 *
 */
public class Controller {

	public static void main(String[] args) {
		//initializes new game
		 Hangman hangman = new Hangman();
		 
		 hangman.loadWords();
		 
		 //scanner to take user input
		 Scanner s = new Scanner(System.in);
		 
		 while (true){
			 //choose a random word from word.txt
			 hangman.randomWord();
			 
			 while(true){
				 //check if game is over
				 if (hangman.isOver()){
					 System.out.println(hangman.status());
					 break;
				//if game is not over
				 } else {
					 System.out.println(hangman.status());
					 
					 //reads the nextLine in user input and change it to lower case
					 String str = s.nextLine().toLowerCase();
					 
					 //checks if user input is empty
					 if (str.length() == 0){
						 System.out.println("Please enter a letter");
						 
					//checks if the first character of user input is a letter 
					 } else if (Character.isLetter(str.charAt(0))) {
						 
						 //set the first character of user input as letter
						 char letter = str.charAt(0);
						 
						 //checks the letter
						 hangman.guess(letter);
					} else {
					
					//prompts user to enter another string
		            System.out.println("Please enter a letter");
		          }
		        }
		      }
		    }

	}

}
