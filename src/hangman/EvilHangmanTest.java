package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvilHangmanTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRandomWord() {
		EvilHangman hangman = new EvilHangman("words_clean.txt");
		ArrayList<String> lines = hangman.loadWords();
		String randomWord = hangman.randomWord(lines);
		
		assertNotEquals(randomWord, "Im not in the list");
		//randomWord should be from the lines list
		assertTrue(lines.contains(randomWord));
		//randomWord should not contain whitespace
		assertFalse(randomWord.contains(" "));
	}

	@Test
	void testFindSameLength() {
		EvilHangman hangman = new EvilHangman("words_clean.txt");
		ArrayList<String> lines = hangman.loadWords();
		String currentWord = hangman.randomWord(lines);
		
		ArrayList<String> sameLengthWords = hangman.findSameLength(lines, currentWord);
		
		System.out.println(sameLengthWords);
		
		String element1 = sameLengthWords.get(0);
		String element2 = sameLengthWords.get(1);
		
		//everything in the Arraylist should have equal length
		assertEquals(element1.length(), element2.length());
		
		//everything in the Arraylist should have equal length to currentWord
		assertEquals(element1.length(), currentWord.length());
		
		//everything not in the Arraylist should have different length
		//when added to the sameLengthWords list, the words gets removed from lines
		assertNotEquals(element1.length(), lines.get(0).length());
	}

	@Test
	void testStatus() {
		EvilHangman hangman = new EvilHangman("words_clean.txt");
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



}
