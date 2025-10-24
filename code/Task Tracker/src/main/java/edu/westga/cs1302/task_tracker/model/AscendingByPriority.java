package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Sorts tasks into ascending order
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 */
public class AscendingByPriority implements Comparator<Task>  {
	private final String ascend = "Ascending by Priority";
	
	
	
  /** Compares tasks priority
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
		
		/** Returns the name of the task to represent the task as a String
		 * 
		 * @precondition none
		 * @postcondition none
		 * 
		 * @return the name of the task
		 */
		@Override
		public String toString() {
			return this.ascend;
		}
	}


