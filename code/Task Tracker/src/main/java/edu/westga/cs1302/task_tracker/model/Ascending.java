package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Sorts tasks into ascending order
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 */
public class Ascending implements Comparator<Task>  {
	
  /** Compares tasks
   * 
   * @param task1 task that will be compared
   * @param task2 second task that will be compared
   * 
   * @return int an int that sorts the tasks by priority
*/
		@Override
		public int compare(Task task1, Task task2)throws NullPointerException {
			if (task1.equals(null) || task2.equals(null)) {
				throw new NullPointerException("task cannot be null");
			}
		return task1.getPriority().compareTo(task2.getPriority()) * -1;
		}
	}
