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
	 * @param name name of the Task
	 * @param description description of the Task
	 * @param priority priority of the Task
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);	
		this.listOfSubTasks = new ArrayList<Task>();
		
	}
	
	/** Get the list of subTasks
	 * 
	 * @return returns a list of subTasks
	 */
	@Override
	public ArrayList<Task> getSubTasks() {
	
		return this.listOfSubTasks;
	}
	
	/** Adds task to the list of subTasks
	 * 
	 * @return this itself
	 */
	@Override
	public ContainerTask addTask(Task subTask) {
		
		this.listOfSubTasks.add(subTask);
		
		return this;
	}
	
	/** Returns the name of the task to represent the task as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task modified with a '+'
	 */
	@Override
	public String toString() {
		return super.getName() + "+";
	}
	
	
	
}