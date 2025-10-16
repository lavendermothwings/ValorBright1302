package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Sorts tasks into descending order
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 * @param task task to compare priorities
 * @param task another task from the list to compare priorities
 * @return int that that sorts the tasks by priority
 */
public class Descending implements Comparator<Task>  {
	
		@Override
		public int compare(Task task1, Task task2) {
			if(task1.equals(null) || task2.equals(null)) {
				throw new NullPointerException("task cannot be null");
			}
		return task1.getPriority().compareTo(task2.getPriority());
		}
	}