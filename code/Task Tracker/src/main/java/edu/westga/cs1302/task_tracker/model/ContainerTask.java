package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/** ContainerTask that adds a subTask to Task
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 */
public class ContainerTask extends Task {
	private ArrayList<Task> listOfSubTasks;
	
	/** Create a new ContainerTask class with the Task information
	 * 
	 * @precondition name != null && !name.isEmpty() &&
	 * 				description != null &&
	 * 				priority != null
	 * 
	 * 
	 * @param name name of the Task
	 * @param description description of the Task
	 * @param priority priority of the Task
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		if (description == null) {
			throw new IllegalArgumentException("description must not be null");
		}
		if (priority == null) {
			throw new IllegalArgumentException("priority must not be null");
		}
		this.listOfSubTasks = new ArrayList<Task>();
		
	}
	
	/** Get the list of subTasks
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return this.listOfSubTasks a list of subTasks
	 */
	@Override
	public ArrayList<Task> getSubTasks() {
	
		return this.listOfSubTasks;
	}
	
	/** Adds task to the list of subTasks
	 * 
	 * @precondition subTask != null
	 * @postcondition size() == size()@pre+1
	 * 
	 * @return this itself
	 */
	@Override
	public ContainerTask addTask(Task subTask) {
		if (subTask == null) {
			throw new IllegalArgumentException("subtask must not be null");
		}
		this.listOfSubTasks.add(subTask);
		
		return this;
	}
	
	/** Returns the name of the task to represent the task as a String
	 * 
	 * 
	 * @return name the name of the task modified with a '+'
	 */
	@Override
	public String toString() {
		return super.getName() + "+";
	}
	
}