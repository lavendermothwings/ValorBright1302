package edu.westga.cs1302.Project1ValorBright2025.model;

import java.util.Comparator;

public class Ascending implements Comparator<Task>  {
		
		@Override
		public int compare(Task task1, Task task2) {
			return Integer.compare(task1.getPriorityValue(), task2.getPriorityValue());
		}
	}


