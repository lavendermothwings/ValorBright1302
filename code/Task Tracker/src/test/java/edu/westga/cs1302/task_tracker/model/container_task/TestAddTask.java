package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void test() {
		Task task = new Task("test task name", "test task descripton", TaskPriority.HIGH);
		ContainerTask contTask = new ContainerTask(task.getName(), task.getDescription(), task.getPriority());
		
		assertThrows(IllegalArgumentException.class, ()->{contTask.addTask(null);});
	}
	
	@Test
	void testValidSubTask() {
	Task subTask = new Task("name", "description", TaskPriority.HIGH);
	Task task = new Task("test task name", "test task descripton", TaskPriority.HIGH);
	ContainerTask contTask = new ContainerTask(task.getName(), task.getDescription(), task.getPriority());
	
	assertEquals(contTask.addTask(subTask).toString(), "test task name+", "checking subTask");
	}

}
