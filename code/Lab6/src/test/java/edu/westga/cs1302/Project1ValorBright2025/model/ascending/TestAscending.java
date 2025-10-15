package edu.westga.cs1302.Project1ValorBright2025.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Project1ValorBright2025.model.Task;

import edu.westga.cs1302.Project1ValorBright2025.model.Ascending;


class TestAscending {

	@Test
	void testWithNullTask() {
	Ascending ascend = new Ascending();
	
	assertThrows(NullPointerException.class, ()-> {ascend.compare(null, null);});
	}
	
	
	
	@Test
	void testWithOneTask() {
	Ascending ascend = new Ascending();
	ArrayList<Task> taskArray = new ArrayList<Task>();
	Task task1 = new Task("taskHigh1", "example", "High");
	taskArray.add(task1);
	taskArray.sort(ascend);
	
	assertEquals(taskArray.toString(), "[taskHigh1]");
	}
	
	@Test
	void testWithTwoTask() {
	Ascending ascend = new Ascending();
	ArrayList<Task> taskArray = new ArrayList<Task>();
	Task task1 = new Task("taskHigh1", "example", "High");
	Task task2 = new Task("taskLow1", "example", "Low");
	
	taskArray.add(task1);
	taskArray.add(task2);
	taskArray.sort(ascend);
	
	assertEquals(taskArray.toString(), "[taskLow1, taskHigh1]");
	}
	
	@Test
	void testWithMultipleTask() {
	Ascending ascend = new Ascending();
	ArrayList<Task> taskArray = new ArrayList<Task>();
	Task task1 = new Task("taskHigh1", "example", "High");
	Task task9 = new Task("taskHigh2", "example", "High");
	Task task4 = new Task("taskHigh3", "example", "High");
	Task task8 = new Task("taskMedium1", "example", "Medium");
	Task task3 = new Task("taskMedium2", "example", "Medium");
	Task task7 = new Task("taskMedium3", "example", "Medium");
	Task task5 = new Task("taskLow1", "example", "Low");
	Task task6 = new Task("taskLow2", "example", "Low");
	Task task2 = new Task("taskLow3", "example", "Low");
	
	taskArray.add(task1);
	taskArray.add(task2);
	taskArray.add(task3);
	taskArray.add(task4);
	taskArray.add(task5);
	taskArray.add(task6);
	taskArray.add(task7);
	taskArray.add(task8);
	taskArray.add(task9);
	
	taskArray.sort(ascend);
	
	assertEquals(taskArray.toString(), "[taskLow3, taskLow1, taskLow2, taskMedium2, taskMedium3, taskMedium1, taskHigh1, taskHigh3, taskHigh2]");
	}
	
	@Test
	void testWithAllHighTask() {
		Ascending ascend = new Ascending();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("taskHigh1", "example", "High");
		Task task2 = new Task("taskHigh2", "example", "High");
		Task task3 = new Task("taskHigh3", "example", "High");
		
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		taskArray.sort(ascend);
		
		assertEquals(taskArray.toString(), "[taskHigh1, taskHigh2, taskHigh3]");
	}
	
	@Test 
	void testWithAllMediumTask() {
		Ascending ascend = new Ascending();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("taskMedium1", "example", "Medium");
		Task task2 = new Task("taskMedium2", "example", "Medium");
		Task task3 = new Task("taskMedium3", "example", "Medium");
		
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		taskArray.sort(ascend);
		
		assertEquals(taskArray.toString(), "[taskMedium1, taskMedium2, taskMedium3]");
	}
	
	@Test
	void testWithAllLowTask() {
		Ascending ascend = new Ascending();
		ArrayList<Task> taskArray = new ArrayList<Task>();
		Task task1 = new Task("taskLow1", "example", "Low");
		Task task2 = new Task("taskLow2", "example", "Low");
		Task task3 = new Task("taskLow3", "example", "Low");
		
		taskArray.add(task1);
		taskArray.add(task2);
		taskArray.add(task3);
		taskArray.sort(ascend);
		
		assertEquals(taskArray.toString(), "[taskLow1, taskLow2, taskLow3]");
	}
		

}
