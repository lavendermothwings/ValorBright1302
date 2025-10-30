package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new ContainerTask(null, "description", TaskPriority.HIGH);});
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, ()->{new ContainerTask("", "description", TaskPriority.HIGH);});
	}

	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new ContainerTask("name", null, TaskPriority.HIGH);});
	}

	@Test
	void testNullPriority() {
		assertThrows(IllegalArgumentException.class, ()->{new ContainerTask("name", "description", null);});
	}

	@Test
	void testValidArguments() {
		ContainerTask result = new ContainerTask("name", "description", TaskPriority.HIGH);
		
		assertEquals("name", result.getName(), "checking name");
		assertEquals("description", result.getDescription(), "checking description");
		assertEquals(TaskPriority.HIGH, result.getPriority(), "checking priority");
	}

}
