package edu.westga.cs1302.Project1ValorBright2025.model.countpriority;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Project1ValorBright2025.model.Task;
import edu.westga.cs1302.Project1ValorBright2025.model.CountPriority;

class TestCountPriority {

	
	@Test
	void testNullPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		String priority = null;
		taskArray.add(task1);
		
		assertThrows(IllegalArgumentException.class, ()-> {counter.getCount(priority, taskArray);});
	}
	
	@Test
	void testPriorityIsEmpty () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		String priority = "";
		taskArray.add(task1);
		
		assertThrows(IllegalArgumentException.class, ()-> {counter.getCount(priority, taskArray);});
	}
	
	@Test
	void testPriorityIsBlank () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		String priority = " ";
		taskArray.add(task1);
		
		assertThrows(IllegalArgumentException.class, ()-> {counter.getCount(priority, taskArray);});
	}
	
	@Test
	void testCountPriorityWithNoTask () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		String priority = "High";
		assertThrows(IllegalArgumentException.class, ()-> {counter.getCount(priority, taskArray);});
	}
	@Test
	void testCountPriorityWithOneTask () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		String priority = "High";
		taskArray.add(task1);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(1, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasks () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		Task task2 = new Task("clean","bathroom","High");
		Task task3 = new Task("clean","kitchen","High");
		String priority = "High";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(3, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasksNoMatchingPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","Low");
		Task task2 = new Task("clean","bathroom","Low");
		Task task3 = new Task("clean","kitchen","Low");
		String priority = "High";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(0, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasksWithOneMatchingPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","Low");
		Task task2 = new Task("clean","bathroom","High");
		Task task3 = new Task("clean","kitchen","Low");
		String priority = "High";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(1, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasksHighMatchingPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","High");
		Task task2 = new Task("clean","bathroom","High");
		Task task3 = new Task("clean","kitchen","High");
		String priority = "High";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(3, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasksMediumMatchingPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","Medium");
		Task task2 = new Task("clean","bathroom","Medium");
		Task task3 = new Task("clean","kitchen","Medium");
		String priority = "Medium";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(3, count);
	}
	
	@Test
	void testCountPriorityWithMultipleTasksLowMatchingPriority () {
		CountPriority counter = new CountPriority();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("clean","room","Low");
		Task task2 = new Task("clean","bathroom","Low");
		Task task3 = new Task("clean","kitchen","Low");
		String priority = "Low";
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		int count = 0;
		count = counter.getCount(priority, taskArray);
		assertEquals(3, count);
	}
	
	
	
//	CountPriority counter = new CountPriority();
//	ArrayList<Task> taskArray = new ArrayList<Task>();
//	Task task1 = new Task("clean","room","High");
//	Task task2 = new Task("clean","bathroom","High");
//	Task task3 = new Task("clean","kitchen","High");
//	String priority = "High";
//	
//	counter.getCount(priority, taskArray);
	
//	@Test
//	void testEmptyPriority () {
//		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "room", "");});
//	}
//	
//	@Test
//	void testBlankPriority () {
//		assertThrows(IllegalArgumentException.class, ()-> {new Task("clean", "room", " ");});
//	}
//	
//	@Test
//	void testTaskPriority() {
//		Task newTask = new Task("clean", "room", "High");
//		assertEquals("High", newTask.getPriority());
//	}

}
