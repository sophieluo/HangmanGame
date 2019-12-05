package hangman;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraditionalHangmanTest {

	@BeforeEach
	void setUp() throws Exception {
		
	
	}

	@Test
	void testLoadWords() {
		TraditionalHangman hangman = new TraditionalHangman("words_clean.txt");
		ArrayList<String> lines = hangman.loadWords();
		
		assertEquals(lines.size(), 57);
		assertEquals(lines.get(0), "coil" );
		assertEquals(lines.get(1), "inexpensive" );
		
	}

	@Test
	void testRandomWord() {
		TraditionalHangman hangman = new TraditionalHangman("words_clean.txt");
		ArrayList<String> lines = hangman.loadWords();
		String randomWord = hangman.randomWord(lines);
		
		assertNotEquals(randomWord, "Im not in the list");
		//randomWord should be from the lines list
		assertTrue(lines.contains(randomWord));
		//randomWord should not contain whitespace
		assertFalse(randomWord.contains(" "));
		
	}

	@Test
	void testStatus() {
		
		TraditionalHangman hangman = new TraditionalHangman("words_clean.txt");
		ArrayList<String> lines = hangman.loadWords();
		hangman.randomWord(lines);
		String status = hangman.status();
		
		//check the returning status is a string
		assertTrue(status instanceof String);
		
		//the returning string status should contain something in the format of _,_,_]
		//cannot use assertEquals because not sure how long is the randomWord
		assertTrue(status.contains(", _, _]"));
		
		//the returning string status should contain something in the format of remaining lives: **********|
		assertTrue(status.contains("remaining lives: **********|"));
	}
	
	/**
	 * do you test void method?
	 */
//	@Test
//	void testGuess() {
//		
//	}


}
