package edu.westga.cs1302.Project1ValorBright2025.model.task;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.Project1ValorBright2025.model.Task;


import org.junit.jupiter.api.Test;



class TestTask {

	
	@Test
	void testNullName () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task(null, "room", "High");});
	}
	
	@Test
	void testEmptyName () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("", "room", "High");});
	}
	
	@Test
	void testBlankName () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task(" ", "room", "High");});
	}
	
	@Test
	void testTaskName() {
		Task newTask = new Task("clean", "room", "High");
		assertEquals("clean", newTask.getName());
	}
	
	@Test
	void testNullDescription () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", null, "High");});
	}
	
	@Test
	void testEmptyDescription () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "", "High");});
	}
	
	@Test
	void testBlankDescription () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", " ", "High");});
	}
	
	@Test
	void testTaskDescription() {
		Task newTask = new Task("clean", "room", "High");
		assertEquals("room", newTask.getDescription());
	}
	
	@Test
	void testNullPriority () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "room", null);});
	}
	
	@Test
	void testEmptyPriority () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "room", "");});
	}
	
	@Test
	void testBlankPriority () {
		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "room", " ");});
	}
	
	@Test
	void testTaskPriority() {
		Task newTask = new Task("clean", "room", "High");
		assertEquals("High", newTask.getPriority());
	}
	
	@Test
	void testSetDescription() {
		Task newTask = new Task("clean", "room", "High");
		newTask.setDescription("bathroom");
		assertEquals("bathroom", newTask.getDescription());
	}
	
}
