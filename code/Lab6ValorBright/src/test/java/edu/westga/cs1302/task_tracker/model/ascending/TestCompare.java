package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

		@Test
		void testWithNullTaskOne() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
	
		assertThrows(NullPointerException.class, ()-> {ascend.compare(task1, null);});
		}
		
		@Test
		void testWithNullTaskTwo() {
		Ascending ascend = new Ascending();
		Task task2 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		
		assertThrows(NullPointerException.class, ()-> {ascend.compare(null, task2);});
		}
		
		
		
//		@Test
//		void testWithOneTask() {
//		Ascending ascend = new Ascending();
//		ArrayList<Task> taskArray = new ArrayList<Task>();
//		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
//		taskArray.add(task1);
//		taskArray.sort(ascend);
//		
//		assertEquals(taskArray.toString(), "[taskHigh1]");
//		}
		
		@Test
		void testWithTwoTask() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		Task task2 = new Task("taskLow1", "example", TaskPriority.LOW);
		
		assertEquals(ascend.compare(task1, task2), 2);
		}
		
		@Test
		void testWithHighMedium() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);
		
		assertEquals(ascend.compare(task1, task2), 1);
		}
		
		@Test
		void testWithHighHigh() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.HIGH);
		
		assertEquals(ascend.compare(task1, task2), 0);
		}
		
		@Test
		void testWithMediumLow() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);
		
		assertEquals(ascend.compare(task1, task2), 1);
		}
		
		@Test
		void testWithMediumMedium() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);
		
		
		assertEquals(ascend.compare(task1, task2), 0);
		}
		
		@Test
		void testWithLowLow() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.LOW);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);
		
		assertEquals(ascend.compare(task1, task2), 0);
		}
		
		@Test
		void testWithHighLowReverse() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		Task task2 = new Task("taskLow1", "example", TaskPriority.LOW);
		
		assertEquals(ascend.compare(task1, task2), 2);
		}
		
		@Test
		void testWithHighMediumReverse() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.HIGH);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.MEDIUM);
		
		assertEquals(ascend.compare(task1, task2), 1);
		}
		
		@Test
		void testWithMediumLowReverse() {
		Ascending ascend = new Ascending();
		Task task1 = new Task("taskHigh1", "example", TaskPriority.MEDIUM);
		Task task2 = new Task("taskMedium1", "example", TaskPriority.LOW);
		
		assertEquals(ascend.compare(task1, task2), 1);
		}
			
	}
	
	