package edu.westga.cs1302.task_tracker.model_collections;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Collections;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Collections(null);});
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, ()->{new Collections("");});
	}

	@Test
	void testValidArguments() {
		Collections result = new Collections("I Hate FairyLand");
		
		assertEquals("I Hate FairyLand", result.getName());
	}


}

