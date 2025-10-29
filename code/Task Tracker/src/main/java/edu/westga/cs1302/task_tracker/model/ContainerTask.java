package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

public class ContainerTask extends Task {
	private ArrayList<Task> listOfSubTasks = new ArrayList<Task>();
	public Task task;
	public String name;
	
	
	public ContainerTask(String name, String description, TaskPriority priority, Task task) {
		super(name, description, priority);	
		this.task = task;
		
	
	}
	
	@Override
	public ArrayList<Task> getSubTasks() {
	
		return this.listOfSubTasks;
	}
	
	@Override
	public ContainerTask addTask(Task task, Task subTask) {
		ContainerTask newCont = new ContainerTask(subTask.getName(), subTask.getDescription(), subTask.getPriority(), task);
		
		newCont.listOfSubTasks.add(subTask);
		this.name = task.getName();
		
		return newCont;
	}
	
	@Override
	public String toString() {
		String newName = this.name;
	
		
		if (newName.contains("+")) {
			int plusRemove = newName.indexOf('+');
			newName = newName.substring(0, plusRemove);
		}
		
		return newName + "+"; 
	}
	
	
	
}