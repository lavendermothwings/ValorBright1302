package edu.westga.cs1302.Project1ValorBright2025.model;

import java.util.ArrayList;

/** Counts the number of Tasks in each selected priority level
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 */
public class CountPriority {
	private int count = 0;

	/** Get the count of each selected priority level
	 * 
	 * @param priority the selected priority of the Task
	 * @param task the ArrayList from the ListView
	 * @throws IllegalArgumentException
	 * @return count the count of each selected priority
	 */
	
	public int getCount(String priority, ArrayList<Task> task) throws IllegalArgumentException {
		if (priority == null) {
			throw new IllegalArgumentException("no priority selected");
		}
		
		if (priority.isEmpty() || priority.isBlank()) {
			throw new IllegalArgumentException("no priority selected");
		}
		if (task.isEmpty()) {
			throw new IllegalArgumentException("no task in list");
		}
		
		String priCount;
		for (Task getPri : task) {
			priCount = getPri.getPriority();
			if (priCount.equals(priority)) {
				this.count++;
			}
				
		}
		
		
		return this.count;
		
	}
	
}
