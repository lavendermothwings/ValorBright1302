package edu.westga.cs1302.Project1ValorBright2025.model;

import java.util.Comparator;

/** Provides creating a Task with a name, description, and priority level and access to the information
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class Task {

	private final String name;
	private String description;
	private final String priority;
	
	/** Create a task 
	 * 
	 * @precondition name != null, name != empty, name != blank, description != null, description != empty,
	 * 				description != blank, priority != null, priority != empty, priority != blank
	 * @postcondition task is created with parameters
	 * 
	 * @param name name of the task
	 * @param description description of the task
	 * @param priority priority level of the task
	 * 
	 * @throws IllegalArgumentException
	 */
	public Task(String name, String description, String priority) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("no name provided");
		}
		
		if (name.isEmpty() || name.isBlank()) {
			throw new IllegalArgumentException("no name provided");
		}
		
		if (description == null) {
			throw new IllegalArgumentException("no description provided");
		}
		
		if (description.isEmpty() || description.isBlank()) {
			throw new IllegalArgumentException("no description provided");
		}
		
		if (priority == null) {
			throw new IllegalArgumentException("no priority selected");
		}
		
		if (priority.isEmpty() || priority.isBlank()) {
			throw new IllegalArgumentException("no priority selected");
		}
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	/** Gets name from task
	 * 
	 * @return name name of task
	 */
	public String getName() {
		return this.name;
	}
	
	/** Gets description from task
	 * 
	 * @return description description from task
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** Sets description of task
	 * 
	 * @param newDescription new description from updateDescription
	 */
			
	public void setDescription(String newDescription) {
		
			this.description = newDescription;
	}
	
	/** Gets priority from task
	 * 
	 * @return priority priority from task
	 */
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * 
	 */
	public int getPriorityValue() {
		int priorityValue = 0;
		String priority = this.priority;
		if (priority.equals("High")) {
			priorityValue = 3;
		}
		else if (priority.equals("Medium")) {
			priorityValue = 2;
		}
		else {
			priorityValue = 1;
		}
		return priorityValue;
	}
	
	/** Provides a string of the task name
	 * 
	 * @return name String of name of task
	 * 
	 */
	public String toString() {
		return this.name;
	}
	
	}
