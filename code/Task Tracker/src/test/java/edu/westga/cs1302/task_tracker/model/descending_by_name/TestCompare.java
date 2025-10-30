package edu.westga.cs1302.task_tracker.model.descending_by_name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingByName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testO1IsNull() {
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingByName descending = new DescendingByName();
		
		assertThrows(NullPointerException.class, ()->{descending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		DescendingByName descending = new DescendingByName();
		
		assertThrows(NullPointerException.class, ()->{descending.compare(o1, null);});
	}
	
	@Test
	void testO1AAndO2B() {
		Task o1 = new Task("a", "desc", TaskPriority.HIGH);
		Task o2 = new Task("b", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);
		assertTrue(result > 0);
	}
	
	@Test
	void testO1BAndO2A() {
		Task o1 = new Task("b", "desc", TaskPriority.HIGH);
		Task o2 = new Task("a", "desc", TaskPriority.LOW);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testO1AndO2SameStartLetter() {
		Task o1 = new Task("Ample", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("Apple", "desc", TaskPriority.HIGH);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1capitalAAndO2lowerCaseB() {
		Task o1 = new Task("b", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("A", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1AndO2AreSameWord() {
		Task o1 = new Task("apple", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("apple", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1AndO2AreSameWordRandomCapitalization() {
		Task o1 = new Task("aPple", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("applE", "desc", TaskPriority.MEDIUM);
		DescendingByName descending = new DescendingByName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
}