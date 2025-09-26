package edu.westga.cs1302.ValorBrightProject1.model;

public class Task {

	private final String name;
	private String description;
	private String priority;
	
	//make name and priority final
	//toString that returns name of tasks
	
	public Task(String name, String description, String priority) {
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	public String getPriority() {
		return this.priority;
	}
	
	public String toString() {
		return this.name;
	}
	
	
	
	
	
	
}
