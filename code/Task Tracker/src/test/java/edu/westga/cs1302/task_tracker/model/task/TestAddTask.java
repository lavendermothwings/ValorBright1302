package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void testSubTaskIsNull() {
		Task task = new Task("test task name", "test task descripton", TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, ()->{task.addTask(null);});
	}
	
	@Test
	void testValidSubTask() {
		Task subTask = new Task("name", "description", TaskPriority.HIGH);
		Task task = new Task("test task name", "test task descripton", TaskPriority.HIGH);
	
		assertEquals(task.addTask(subTask).toString(), "test task name+", "checking subTask");
	}

}
