package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testWithNullTaskOne() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	
	assertThrows(NullPointerException.class, ()-> {descend.compare(task1, null);});
	}
	
	@Test
	void testWithNullTaskTwo() {
	Descending descend = new Descending();
	Task task2 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	
	assertThrows(NullPointerException.class, ()-> {descend.compare(null, task2);});
	}
	
	@Test
	void testWithHighLow() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	Task task2 = new Task("taskLow1", "example", TaskPriority.LOW);
	
	assertEquals(descend.compare(task1, task2), -2);
	}
	
	@Test
	void testWithHighMedium() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);

	assertEquals(descend.compare(task1, task2), -1);
	}
	
	@Test
	void testWithHighHigh() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.HIGH);
	
	assertEquals(descend.compare(task1, task2), 0);
	}
	
	@Test
	void testWithMediumLow() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);
	
	assertEquals(descend.compare(task1, task2), -1);
	}
	
	@Test
	void testWithMediumMedium() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);
	
	assertEquals(descend.compare(task1, task2), 0);
	}
	
	@Test
	void testWithLowLow() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.LOW);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);
	
	assertEquals(descend.compare(task1, task2), 0);
	}
	
	@Test
	void testWithHighLowReverse() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	Task task2 = new Task("taskLow1", "example", TaskPriority.LOW);

	
	assertEquals(descend.compare(task1, task2), -2);
	}
	
	@Test
	void testWithHighMediumReverse() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);
	
	assertEquals(descend.compare(task1, task2), -1);
	}
	
	@Test
	void testWithMediumLowReverse() {
	Descending descend = new Descending();
	Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
	Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);

	assertEquals(descend.compare(task1, task2), -1);
	}
		
}

