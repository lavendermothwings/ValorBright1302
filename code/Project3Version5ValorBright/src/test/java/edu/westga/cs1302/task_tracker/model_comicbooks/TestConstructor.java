package edu.westga.cs1302.task_tracker.model_comicbooks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ComicBook;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new ComicBook(null, "1");});
	}

	@Test
	void testNullNumber() {
		assertThrows(NullPointerException.class, ()->{new ComicBook("SuperMan: Red Son", null);});
	}
	
	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, ()->{new ComicBook("","");});
	}

	@Test
	void testValidArguments() {
		ComicBook result = new ComicBook("I Hate FairyLand", "1");
		
		assertEquals("I Hate FairyLand", result.toString());
	}

}
